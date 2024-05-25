package com.hamzabekkaoui.freelancerestapi.dto.request;

import com.hamzabekkaoui.freelancerestapi.entities.ExperienceLevel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;
import java.util.List;
import java.util.Set;

public record OfferRequest(
         String title,
         String description,
         String experienceLevel,
         Date publishDate,
         Set<String> offerTechnologies,
         String companyName
) {
}
