package com.hamzabekkaoui.freelancerestapi.dto.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
