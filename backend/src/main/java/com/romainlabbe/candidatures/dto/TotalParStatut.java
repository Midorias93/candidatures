package com.romainlabbe.candidatures.dto;

public record TotalParStatut (
    Long envoyer,
    Long relancee,
    Long entretient,
    Long refus,
    Long offre
) {}