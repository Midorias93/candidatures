package com.romainlabbe.candidatures.dto;

public record TotalParStatut (
    Long ENVOYER,
    Long RELANCEE,
    Long ENTRETIEN,
    Long REFUS,
    Long OFFRE
) {}