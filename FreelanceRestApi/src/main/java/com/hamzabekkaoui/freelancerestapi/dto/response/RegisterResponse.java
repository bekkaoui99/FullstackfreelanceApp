package com.hamzabekkaoui.freelancerestapi.dto.response;

import lombok.Builder;

@Builder
public record RegisterResponse(
        String id,
        String userName,
        String mail

) {
}
