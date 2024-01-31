package org.example.credietoffrehabitat.Entity;


import jakarta.persistence.*;

@Entity
@Table(name="SuivieDemande")
public class SuivieDemandeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "suivieDemande", cascade = CascadeType.ALL)
    private SimulationPretEntity simulationPretEntity;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
