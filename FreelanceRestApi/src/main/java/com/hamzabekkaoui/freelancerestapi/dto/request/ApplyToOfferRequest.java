package com.hamzabekkaoui.freelancerestapi.dto.request;

import lombok.Builder;

@Builder
public record ApplyToOfferRequest(
        String UserName,
        String offerId
) {
}
