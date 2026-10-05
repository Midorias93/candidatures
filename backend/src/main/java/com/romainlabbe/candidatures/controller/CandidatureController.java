package com.romainlabbe.candidatures.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.romainlabbe.candidatures.dto.CandidatureRequest;
import com.romainlabbe.candidatures.dto.CandidatureResponse;
import com.romainlabbe.candidatures.service.CandidatureService;

import jakarta.validation.Valid;


@RestController 
public class CandidatureController{
    private final CandidatureService candidatureSerice;

    public CandidatureController(CandidatureService candidatureService)
    {
        this.candidatureSerice  = candidatureService;
    }

    @GetMapping("/candidatures")
    public List<CandidatureResponse> GetCandidatures() {
        return candidatureSerice.getAllCandidatures();
    }

    @PostMapping("/candidatures")
    public CandidatureResponse createCandidature(@RequestBody @Valid CandidatureRequest request) {
        return candidatureSerice.createCandidature(request);
    }


}