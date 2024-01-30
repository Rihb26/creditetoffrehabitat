package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.awt.*;

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

    private String typeBien;
    private String adresse ;
    private String prix;
    private String description;
    private String pathImg;
     @OneToOne
    private SimulationPretEntity simulationPretEntity;
     @OneToOne
    private AgenceImmobiliereEntity agenceImmobiliereEntity;

}
