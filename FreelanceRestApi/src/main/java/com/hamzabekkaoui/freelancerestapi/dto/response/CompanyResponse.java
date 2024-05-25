package com.hamzabekkaoui.freelancerestapi.dto.response;

import lombok.Builder;

@Builder
public record CompanyResponse(
        String companyName,
        String address
) {
}
