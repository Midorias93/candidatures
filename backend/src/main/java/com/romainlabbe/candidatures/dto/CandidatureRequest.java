package com.romainlabbe.candidatures.dto;

import java.time.LocalDate;

import com.romainlabbe.candidatures.entity.CandidatureStatut;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CandidatureRequest(
    @NotBlank String entreprise,
    @NotBlank String poste,
    @NotNull  CandidatureStatut statut,
    LocalDate dateCandidature,
    String lienOffre,
    int salaire,
    String notes
) {}