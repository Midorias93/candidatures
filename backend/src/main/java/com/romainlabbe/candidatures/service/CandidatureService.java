package com.romainlabbe.candidatures.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.romainlabbe.candidatures.dto.CandidatureResponse;
import com.romainlabbe.candidatures.mapper.CandidatureMapper;
import com.romainlabbe.candidatures.repository.CandidatureRepository;

@Service 
public class CandidatureService {
    private final CandidatureRepository candidatureRepository;

    public CandidatureService(CandidatureRepository candidatureRepository)
    {
        this.candidatureRepository = candidatureRepository;
    }

    public List<CandidatureResponse> getAllCandidatures() {
        return this.candidatureRepository.findAll()
        .stream()
        .map(CandidatureMapper::toReponse)
        .toList();
    }

}