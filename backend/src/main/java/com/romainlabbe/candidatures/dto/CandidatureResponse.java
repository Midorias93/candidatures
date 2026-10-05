package com.romainlabbe.candidatures.dto;

import java.time.LocalDate;

import com.romainlabbe.candidatures.entity.CandidatureStatut;

public record CandidatureResponse(
    Long id,
    String entreprise,
    String poste,
    CandidatureStatut statut,
    LocalDate date
) {}

