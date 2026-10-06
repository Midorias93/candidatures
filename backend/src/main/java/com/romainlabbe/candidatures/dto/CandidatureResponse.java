package com.romainlabbe.candidatures.dto;

import java.time.Instant;
import java.time.LocalDate;

import com.romainlabbe.candidatures.entity.CandidatureStatut;

public record CandidatureResponse(
    Long id,
    String entreprise,
    String poste,
    CandidatureStatut statut,
    LocalDate dateCandidature,
    String lienOffre,
    int salaire,
    String notes,
    Instant createdAt,
    Instant UpdatedAt
) {}

