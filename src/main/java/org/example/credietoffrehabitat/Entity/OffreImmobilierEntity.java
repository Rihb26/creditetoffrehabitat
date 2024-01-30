package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OffreImmobilierEntity {

    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
