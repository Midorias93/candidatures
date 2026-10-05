package com.romainlabbe.candidatures.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.romainlabbe.candidatures.entity.Candidature;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {
}