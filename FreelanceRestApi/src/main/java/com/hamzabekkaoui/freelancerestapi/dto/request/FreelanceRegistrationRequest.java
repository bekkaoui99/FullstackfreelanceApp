package com.hamzabekkaoui.freelancerestapi.dto.request;

import lombok.Builder;

import java.util.List;

@Builder
public record FreelanceRegistrationRequest(
        String firstName,
        String lastName,
        String userName,
        String email,
        String phoneNumber,
        String city,
        String jobTitle,
        String imageUrl,
        String cvUrl,
        List<TechnologyRequest> technologies,
        String password,
        String confirmationPassword
) {
}
