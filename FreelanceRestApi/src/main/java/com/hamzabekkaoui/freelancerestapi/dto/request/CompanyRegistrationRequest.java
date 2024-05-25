package com.hamzabekkaoui.freelancerestapi.dto.request;

import lombok.Builder;

@Builder
public record CompanyRegistrationRequest(
        String companyName,
        String address,
        String email,
        String password,
        String confirmationPassword
) {
}
