package com.hamzabekkaoui.freelancerestapi.dto.response;

import lombok.Builder;

import java.util.Date;
import java.util.Set;

@Builder
public record OfferResponse(
         String id,
         String title,
         String description,
         String experienceLevel,
         Date publishDate,
         Set<String> offerTechnologies,
         String companyName
) {
}
