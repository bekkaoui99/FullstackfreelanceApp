package com.hamzabekkaoui.freelancerestapi.security.Controller;


import com.hamzabekkaoui.freelancerestapi.dto.request.AuthenticationRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.CompanyRegistrationRequest;
import com.hamzabekkaoui.freelancerestapi.dto.request.FreelanceRegistrationRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.AuthenticationResponse;
import com.hamzabekkaoui.freelancerestapi.dto.response.RegisterResponse;
import com.hamzabekkaoui.freelancerestapi.security.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    @PostMapping("/freelanceRegistration")
    public ResponseEntity<RegisterResponse> freelanceRegistration(@RequestBody FreelanceRegistrationRequest registerRequest){

        RegisterResponse response = authenticationService.freelanceRegistration(registerRequest);
        return new ResponseEntity<>(response , HttpStatus.CREATED);

    }

    @PostMapping("/companyRegistration")
    public ResponseEntity<RegisterResponse> companyRegistration(@RequestBody CompanyRegistrationRequest registerRequest){

        RegisterResponse response = authenticationService.companyRegistration(registerRequest);
        return new ResponseEntity<>(response , HttpStatus.CREATED);

    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest authenticationRequest){

        AuthenticationResponse response = authenticationService.login(authenticationRequest);
        return new ResponseEntity<>(response , HttpStatus.CREATED);

    }

    @PostMapping("/refreshToken")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    )throws Exception{
        authenticationService.refreshToken(request, response);
    }

}
