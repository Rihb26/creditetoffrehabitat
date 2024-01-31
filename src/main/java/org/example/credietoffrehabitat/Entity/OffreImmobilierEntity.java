package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="OffreImmobilier")
public class OffreImmobilierEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeBien;
    private String adresse ;
    private String prix;
    private String description;
    private String pathImg;
    @OneToOne(mappedBy = "offreImmobilierEntity", cascade = CascadeType.ALL)
    private AgenceImmobiliereEntity agenceImmobiliereEntity;

    @ManyToOne
    @JoinColumn(name = "id_simulation_pret")
    private SimulationPretEntity simulationPretEntity;

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

}
