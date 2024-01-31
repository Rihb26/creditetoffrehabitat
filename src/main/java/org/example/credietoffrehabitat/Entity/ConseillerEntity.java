package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.OneToMany;

public class ConseillerEntity {
    private int idConseiller;

    @OneToMany
    private SuivieDemandeEntity suivieDemandeEntity;
}


