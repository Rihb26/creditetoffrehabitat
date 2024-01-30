package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.Entity;

@Entity
public class SimulationPret {
    private String resultat;
    private String montantPret;

    private String tauxInteret;

    private ClientEntity client;

    private OffreImmobilier offreImmobilier;
}
