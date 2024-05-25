package com.hamzabekkaoui.freelancerestapi.mapper;

import com.hamzabekkaoui.freelancerestapi.dto.response.FreelanceResponse;
import com.hamzabekkaoui.freelancerestapi.entities.Freelance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FreelanceMapper {

    private final TechnologyMapper technologyMapper;

    public FreelanceResponse freelaceToFreelanceResponse(Freelance freelance) {

        return FreelanceResponse.builder()
                .firstName(freelance.getFirstName())
                .lastName(freelance.getLastName())
                .userName(freelance.getUserName())
                .jobTitle(freelance.getJobTitle())
                .image(freelance.getImage())
                .city(freelance.getCity())
                .technologyResponses(
                        freelance.getTechnologies()
                                .stream()
                                .map(technologyMapper::technologyToTechnologyResponse)
                                .toList()
                )
                .build();
    }

}
