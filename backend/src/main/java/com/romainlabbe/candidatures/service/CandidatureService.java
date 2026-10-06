package com.romainlabbe.candidatures.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.romainlabbe.candidatures.dto.CandidatureRequest;
import com.romainlabbe.candidatures.dto.CandidatureResponse;
import com.romainlabbe.candidatures.dto.StatsResponse;
import com.romainlabbe.candidatures.dto.TotalParStatut;
import com.romainlabbe.candidatures.entity.Candidature;
import com.romainlabbe.candidatures.entity.CandidatureStatut;
import com.romainlabbe.candidatures.mapper.CandidatureMapper;
import com.romainlabbe.candidatures.repository.CandidatureRepository;

@Service 
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;

    public CandidatureService(CandidatureRepository candidatureRepository)
    {
        this.candidatureRepository = candidatureRepository;
    }

    public CandidatureResponse createCandidature(CandidatureRequest resquest){
        Candidature saved = this.candidatureRepository.save(CandidatureMapper.toEntity(resquest));
        return CandidatureMapper.toReponse(saved);
    }

    public List<CandidatureResponse> getAllCandidatures() {
        return this.candidatureRepository.findAll()
        .stream()
        .map(CandidatureMapper::toReponse)
        .toList();
    }

    public CandidatureResponse getCandidature(Long id) {
        return CandidatureMapper.toReponse(this.candidatureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidature Introuvable")));
    }

    public CandidatureResponse editCandidature(Long id, CandidatureRequest request)   {
        Candidature candidature = this.candidatureRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Candidature Introuvable"));
        candidature.setEntreprise(request.entreprise());
        candidature.setPoste(request.poste());
        candidature.setStatut(request.statut());
        candidature.setDateCandidature(request.dateCandidature());
        candidature.setLienOffre(request.lienOffre());
        candidature.setSalaire(request.salaire()); 
        candidature.setNotes(request.notes()); 

        Candidature saved = this.candidatureRepository.save(candidature);
        return CandidatureMapper.toReponse(saved);
    }

    public void deleteCandidature(Long id) {
        this.candidatureRepository.deleteById(id);
    }

    public StatsResponse getStats() {
        Long total = this.candidatureRepository.count();
        TotalParStatut totalParStatut = new TotalParStatut(this.candidatureRepository.countByStatut(CandidatureStatut.ENVOYER),
            this.candidatureRepository.countByStatut(CandidatureStatut.RELANCEE),
            this.candidatureRepository.countByStatut(CandidatureStatut.ENTRETIEN),
            this.candidatureRepository.countByStatut(CandidatureStatut.REFUS),
            this.candidatureRepository.countByStatut(CandidatureStatut.OFFRE));
        float tauxReponse = (totalParStatut.entretient() + totalParStatut.offre()) / total;
        float tauxEntretien = (totalParStatut.entretient() + totalParStatut.refus() + totalParStatut.offre()) / total;
        List<Long> idRelancee = this.candidatureRepository.findByDateCandidatureBefore(LocalDate.now().minusWeeks(2)).stream().map(Candidature::getId).toList();
        int salaireMax = this.candidatureRepository.findSalaireMax();
        int salaireMin = this.candidatureRepository.findSalaireMin();

        return new StatsResponse(total, totalParStatut, tauxReponse, tauxEntretien, idRelancee, salaireMax,salaireMin);
    }
}