package com.romainlabbe.candidatures.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.romainlabbe.candidatures.dto.CandidatureRequest;
import com.romainlabbe.candidatures.dto.CandidatureResponse;
import com.romainlabbe.candidatures.dto.StatsResponse;
import com.romainlabbe.candidatures.service.CandidatureService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController 
public class CandidatureController{
    private final CandidatureService candidatureSerice;

    public CandidatureController(CandidatureService candidatureService)
    {
        this.candidatureSerice  = candidatureService;
    }

    @GetMapping("/candidatures")
    public List<CandidatureResponse> getCandidatures() {
        return candidatureSerice.getAllCandidatures();
    }

    @GetMapping("/candidatures/{id}")
    public CandidatureResponse getCandidature(@PathVariable(value = "id") Long id) {
        return candidatureSerice.getCandidature(id);
    }
    
    @GetMapping("/candidatures/stats")
    public StatsResponse getStats() {
        return candidatureSerice.getStats();
    }

    @PostMapping("/candidatures")
    public CandidatureResponse createCandidature(@RequestBody @Valid CandidatureRequest request) {
        return candidatureSerice.createCandidature(request);
    }
    @PutMapping("/candidatures/{id}")
    public CandidatureResponse editCandidature(@PathVariable(value = "id") Long id, @RequestBody @Valid CandidatureRequest request) {
        return candidatureSerice.editCandidature(id, request);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @DeleteMapping("/candidatures/{id}")
    public void deleteCandidature(@PathVariable(value = "id") Long id) {
        candidatureSerice.deleteCandidature(id);
    }

}