package com.romainlabbe.candidatures.mapper;

import com.romainlabbe.candidatures.entity.Candidature;
import com.romainlabbe.candidatures.dto.CandidatureRequest;
import com.romainlabbe.candidatures.dto.CandidatureResponse;


public class CandidatureMapper {

    public static CandidatureResponse toReponse(Candidature entity) {
        return new CandidatureResponse(
            entity.getId(),
            entity.getEntreprise(),
            entity.getPoste(),
            entity.getStatut(),
            entity.getDateCandidature(),
            entity.getLienOffre(),
            entity.getSalaire(),
            entity.getNotes(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }

    public static Candidature toEntity(CandidatureRequest request){
        return new Candidature(request.entreprise(), request.poste(), request.statut(), request.dateCandidature(), request.lienOffre(), request.salaire(),request.notes());
    }

    
}