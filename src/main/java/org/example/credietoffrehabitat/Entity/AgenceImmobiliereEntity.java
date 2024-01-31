package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AgenceImmobiliere")
public class AgenceImmobiliereEntity {

    @OneToOne
    private OffreImmobilierEntity offreImmobilierEntity;
    @Id
    @GeneratedValue
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}