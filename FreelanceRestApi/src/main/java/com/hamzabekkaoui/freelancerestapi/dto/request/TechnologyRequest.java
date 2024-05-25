package com.hamzabekkaoui.freelancerestapi.dto.request;

import lombok.Builder;

@Builder
public record TechnologyRequest(
        String name,
        String level
) {
}
