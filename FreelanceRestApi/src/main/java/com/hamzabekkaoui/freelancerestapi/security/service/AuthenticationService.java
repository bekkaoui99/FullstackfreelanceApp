package com.hamzabekkaoui.freelancerestapi.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hamzabekkaoui.freelancerestapi.entities.Company;
import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import com.hamzabekkaoui.freelancerestapi.entities.Role;
import com.hamzabekkaoui.freelancerestapi.entities.Technology;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceAlreadyExist;
import com.hamzabekkaoui.freelancerestapi.exceptions.ResourceNotFoundException;
import com.hamzabekkaoui.freelancerestapi.mapper.TechnologyMapper;
import com.hamzabekkaoui.freelancerestapi.repositories.TechnologyRepository;
import com.hamzabekkaoui.freelancerestapi.repositories.UserRepository;
import com.hamzabekkaoui.freelancerestapi.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.CompanyRegistrationRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.FreelanceRegistrationRequest;

import com.hamzabekkaoui.freelancerestapi.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.RegisterResponse;
import com.hamzabekkaoui.freelancerestapi.security.model.SecurityUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TechnologyMapper technologyMapper;
    private final TechnologyRepository technologyRepository;
    private final JwtService jwtService;

    @Transactional
    public RegisterResponse freelanceRegistration(FreelanceRegistrationRequest registerRequest) {
        boolean exist = userRepository.existsByEmail(registerRequest.email());
        if(exist) throw new ResourceAlreadyExist("this mail : " + registerRequest.email() + " already exist ");

        if(!registerRequest.password().equals(registerRequest.confirmationPassword()))
            throw new IllegalArgumentException("confirmation password doesn't match with the password :(");

        Freelance freelance = new Freelance();
        freelance.setId(UUID.randomUUID().toString());
        freelance.setFirstName(registerRequest.firstName());
        freelance.setLastName(registerRequest.lastName());
        freelance.setUserName(registerRequest.userName());
        freelance.setEmail(registerRequest.email());
        freelance.setPhoneNumber(registerRequest.phoneNumber());
        freelance.setCity(registerRequest.city());
        freelance.setJobTitle(registerRequest.jobTitle());
        freelance.setImage(registerRequest.imageUrl());
        freelance.setCV(registerRequest.cvUrl());
        freelance.setPassword(passwordEncoder.encode(registerRequest.password()));
        Set<Role> authorities = new HashSet<>();
        authorities.add(Role.FREELANCE);
        freelance.setAuthorities(authorities);
        Set<Technology> technologies = new HashSet<>();
        if(registerRequest.technologies() != null){

            Set<Technology>  technologiesRequest = registerRequest.technologies()
                    .stream()
                    .map(technologyMapper::technologyRequestToTechnology)
                    .collect(Collectors.toSet());

            for (Technology technology : technologiesRequest) {
                boolean existsByNameAndLevel = technologyRepository.existsByNameAndLevel(technology.getName(), technology.getLevel());
                if(!existsByNameAndLevel) {
                    technologyRepository.save(technology);
                }
                technologies.add(technology);
            }
        }
        freelance.setTechnologies(technologies);

        Freelance createdFreelance = userRepository.save(freelance);

        return RegisterResponse.builder()
                .id(createdFreelance.getId())
                .userName(createdFreelance.getUserName())
                .mail(createdFreelance.getEmail())
                .build();
    }


    public RegisterResponse companyRegistration(CompanyRegistrationRequest registerRequest) {
        boolean exist = userRepository.existsByEmail(registerRequest.email());
        if(exist) throw new ResourceAlreadyExist("this mail : " + registerRequest.email() + " already exist ");
        if(!registerRequest.password().equals(registerRequest.confirmationPassword()))
            throw new IllegalArgumentException("confirmation password doesn't match with the password :(");

        Company company = new Company();
        company.setId(UUID.randomUUID().toString());
        company.setCompanyName(registerRequest.companyName());
        company.setAddress(registerRequest.address());
        company.setEmail(registerRequest.email());
        company.setPassword(passwordEncoder.encode(registerRequest.password()));
        Set<Role> authorities = new HashSet<>();
        authorities.add(Role.COMPANY);
        company.setAuthorities(authorities);
        Company createdCompany = userRepository.save(company);


        return RegisterResponse.builder()
                .id(createdCompany.getId())
                .mail(createdCompany.getEmail())
                .userName(createdCompany.getCompanyName())
                .build();
    }



    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
        SecurityUser user = userRepository.findByEmail(authenticationRequest.email())
                .map(SecurityUser::new)
                .orElseThrow(() -> new ResourceNotFoundException("something went wrong"));

        if(user.getPassword().equals(passwordEncoder.encode(authenticationRequest.password())))
            throw new IllegalArgumentException("something went wrong");

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.email(), authenticationRequest.password())
        );

        Map<String, Object> claims = new HashMap<>();
        String roles = authenticate.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        claims.put("role", roles);
        String accessToken = jwtService.generateToken(claims, user);
        String refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .userName(user.getUsername())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

    }



    public void refreshToken(HttpServletRequest request,
                             HttpServletResponse response
    ) throws Exception {
        final String authHeader = request.getHeader("Authorization");
        final String refreshToken;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);

        username = jwtService.extractUsername(refreshToken);
        if (username != null) {
            var user = this.userRepository.findByEmail(username)
                    .map(SecurityUser::new)
                    .orElseThrow(() -> new UsernameNotFoundException("user not found :( "));
            if (jwtService.isTokenValid(refreshToken, user)) {
                String newAccessToken = jwtService.generateToken(new HashMap<>(), user);


                var _response = AuthenticationResponse.builder()
                        .userName(user.getUsername())
                        .accessToken(newAccessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper()
                        .writeValue(
                                response.getOutputStream(),
                                _response);
            }
        }
    }
}
