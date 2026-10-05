package com.romainlabbe.candidatures.dto;

import jakarta.validation.constraints.NotBlank;

public record HelloworldResponse(
    @NotBlank String message
) {
}