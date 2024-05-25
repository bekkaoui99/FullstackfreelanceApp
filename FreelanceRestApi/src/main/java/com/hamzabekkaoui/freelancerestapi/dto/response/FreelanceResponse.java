package com.hamzabekkaoui.freelancerestapi.dto.response;

import lombok.Builder;

import java.util.List;

@Builder
public record FreelanceResponse(
        String firstName,
        String lastName,
        String userName,
        String city,
        String jobTitle,
        String image,
        List<TechnologyResponse> technologyResponses

) {
}
