package com.romainlabbe.candidatures.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.romainlabbe.candidatures.entity.Candidature;
import com.romainlabbe.candidatures.entity.CandidatureStatut;

public interface CandidatureRepository extends JpaRepository<Candidature, Long> {

    Long countByStatut(CandidatureStatut Statut);

    @Query("SELECT MAX(c.salaire) FROM Candidature c")
    Long findSalaireMax();

    @Query("SELECT MIN(c.salaire) FROM Candidature c")
    Long findSalaireMin();

    List<Candidature> findByDateCandidatureBefore(LocalDate dateCandidature);
}