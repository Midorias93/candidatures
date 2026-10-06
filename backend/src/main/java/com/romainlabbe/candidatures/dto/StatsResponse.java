package com.romainlabbe.candidatures.dto;
import java.util.List;

public record StatsResponse(
    Long total,
    TotalParStatut parStatut,
    float tauxReponse,
    float tauxEntretien,
    List<Long> idRelancee,
    Long salaireMax,
    Long salaireMin
) {}
