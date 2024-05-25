package com.hamzabekkaoui.freelancerestapi.dto.response;

import lombok.Builder;

@Builder
public record TechnologyResponse(
        String name,
        String level
) {
}
