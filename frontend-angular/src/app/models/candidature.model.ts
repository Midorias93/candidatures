export type CandidatureStatut = 'ENVOYER' | 'RELANCEE' | 'ENTRETIEN' | 'OFFRE' | 'REFUS';

export interface Candidature {
    id: number;
    entreprise: string;
    poste: string;
    statut: CandidatureStatut;
    dateCandidature?: string;
    lienOffre?: string;
    salaire?: number;
    notes?: string;
    createdAt: string;
    updatedAt: string;
};

export interface TotalParStatut {
  ENVOYER: number;
  RELANCEE: number;
  ENTRETIEN: number;
  OFFRE: number;
  REFUS: number;
};

export interface Stats {
  total: number;
  parStatut: TotalParStatut;
  tauxReponse: number;
  tauxEntretien: number;
  idRelancee: number[];
  salaireMax: number;
  salaireMin: number;
};
