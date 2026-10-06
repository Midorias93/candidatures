# Spec — Front Angular Candidatures

Document de référence pour construire le front à partir de la maquette `Tableau de bord — candidatures@2x.png`.

Règle de collaboration : l'utilisateur apprend. L'agent guide étape par étape, l'utilisateur écrit le code. Backend à ne pas modifier sans demande explicite.

---

## État des lieux

### Backend disponible (ne pas modifier)
- `GET /candidatures` — liste
- `GET /candidatures/{id}` — détail
- `GET /candidatures/stats` — KPI du haut
- `POST /candidatures` — création
- `PUT /candidatures/{id}` — édition (ex : changement de statut)
- `DELETE /candidatures/{id}`
- CORS autorisé pour `http://localhost:4200`

### Front
- Angular 21 fraîchement initialisé
- `src/app/models/candidature.model.ts` vide
- `src/app/app.routes.ts` vide

---

## Découpage de la maquette

1. **Header** — titre + boutons `Exporter` / `Nouvelle candidature`
2. **4 cartes KPI** — Candidatures envoyées, En cours, Entretiens, Offres (nourries par `/candidatures/stats`)
3. **Barre de filtres** — recherche + onglets par statut + toggle Pipeline/Liste
4. **Vue Pipeline (Kanban)** — 5 colonnes : Envoyée, À relancer, Entretien, Offre, Refusée
5. **Panneau latéral de détail** — s'ouvre au clic sur une carte

---

## Plan d'attaque

### Étape 1 — Modèles TypeScript
Dans `src/app/models/candidature.model.ts` :
- interface `Candidature` miroir de `CandidatureResponse` (attention : `LocalDate` → `string`, `Instant` → `string`)
- type/enum `CandidatureStatut` aligné sur l'enum Java
- interface `Stats` miroir de `StatsResponse`

### Étape 2 — Service HTTP
- `ng generate service services/candidature`
- Enregistrer `provideHttpClient()` dans `app.config.ts`
- Méthodes : `getAll()`, `getById(id)`, `getStats()`, `create()`, `update(id)`, `delete(id)`
- URL de base dans `src/environments/environment.ts`

### Étape 3 — Routes et shell
- Route principale `/` vers `DashboardComponent`
- `ng generate component pages/dashboard`

### Étape 4 — Composants (du plus simple au plus complexe)
1. `StatCardComponent` — ×4 dans le dashboard
2. `FilterBarComponent` — recherche + onglets statuts + toggle vue
3. `CandidatureCardComponent` — carte dans une colonne
4. `PipelineColumnComponent` — une colonne du Kanban
5. `PipelineBoardComponent` — les 5 colonnes
6. `CandidatureDetailComponent` — panneau latéral

### Étape 5 — États et signaux (Angular 21)
Dans `DashboardComponent`, utiliser `signal()`, `computed()`, `resource()` :
- `candidatures` — resource depuis le service
- `stats` — resource
- `filtreStatut` — signal
- `recherche` — signal
- `selectionId` — signal, ouvre le panneau
- `candidaturesFiltrees` — computed à partir des trois signaux au-dessus

### Étape 6 — Style
Choix à faire : Tailwind, CSS pur, ou Angular Material.
- Maquette sobre : gris clair en fond, noir pour les actions, accents colorés par statut
- Tailwind : rapide
- CSS pur : plus formateur
- Material : composants prêts mais style à surcharger

---

## Décisions à prendre avant de démarrer
- [ ] Par quelle étape commencer
- [ ] Choix de la solution de style
