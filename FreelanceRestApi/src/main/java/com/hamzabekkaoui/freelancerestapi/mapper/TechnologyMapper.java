package com.hamzabekkaoui.freelancerestapi.mapper;

import com.hamzabekkaoui.freelancerestapi.entities.Technology;
import com.hamzabekkaoui.freelancerestapi.dto.request.TechnologyRequest;
import com.hamzabekkaoui.freelancerestapi.dto.response.TechnologyResponse;
import org.springframework.stereotype.Service;

@Service
public class TechnologyMapper {

    public Technology technologyRequestToTechnology(TechnologyRequest technologyRequest) {

        return Technology.builder()
                .name(technologyRequest.name())
                .level(technologyRequest.level())
                .build();
    }

    public TechnologyResponse technologyToTechnologyResponse(Technology technology) {

        return TechnologyResponse.builder()
                .name(technology.getName())
                .level(technology.getLevel())
                .build();
    }



}
