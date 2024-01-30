package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class SimulationPretEntity {
    private String resultat;
    private String montantPret;
    private String tauxInteret;
    @ManyToOne
    private ClientEntity client;

    @OneToMany
    private Set<OffreImmobilierEntity> offreImmobilierEntity;
    @OneToOne
    private SuivieDemandeEntity suivieDemandeEntity;

}
