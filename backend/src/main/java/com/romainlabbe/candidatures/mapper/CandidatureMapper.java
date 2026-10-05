package com.romainlabbe.candidatures.mapper;

import com.romainlabbe.candidatures.entity.Candidature;
import com.romainlabbe.candidatures.dto.CandidatureResponse;


public class CandidatureMapper {

    public static CandidatureResponse toReponse(Candidature entity) {
        return new CandidatureResponse(
            entity.getId(),
            entity.getEntreprise(),
            entity.getPoste(),
            entity.getStatut(),
            entity.getDate()
        );

    }

    
}