package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public class AgenceImmobiliereEntity {

    @OneToMany
    private OffreImmobilierEntity offreImmobilierEntity;
}
