package com.romainlabbe.candidatures.entity;

import java.time.Instant;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "candidature")
@Getter @Setter @NoArgsConstructor 
public class Candidature {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entreprise;

    @Column(nullable = false)
    private String poste;

    @Enumerated(EnumType.STRING)
    private CandidatureStatut statut;

    @Column(nullable = true)
    private LocalDate date;

    @Column(nullable = true)
    private String lienOffre;

    @Column(nullable = true)
    private int salaire;
    
    @Column(nullable = true)
    private String notes;

    @CreationTimestamp 
    @Column(updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    private Instant UpdatedAt;
}
