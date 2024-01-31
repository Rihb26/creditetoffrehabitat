package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="SimulationPret")
public class SimulationPretEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String resultat;
    private String montantPret;
    private String tauxInteret;
    @ManyToOne
    private ClientEntity client;

    @OneToMany(mappedBy = "simulationPretEntity", cascade = CascadeType.ALL)
    private Set<OffreImmobilierEntity> offreImmobilierEntity;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id_SimulationPret")
    private SuivieDemandeEntity suivieDemande;

    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    public String getMontantPret() {
        return montantPret;
    }

    public void setMontantPret(String montantPret) {
        this.montantPret = montantPret;
    }

    public String getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(String tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public Set<OffreImmobilierEntity> getOffreImmobilierEntity() {
        return offreImmobilierEntity;
    }

    public void setOffreImmobilierEntity(Set<OffreImmobilierEntity> offreImmobilierEntity) {
        this.offreImmobilierEntity = offreImmobilierEntity;
    }

    public SuivieDemandeEntity getSuivieDemande() {
        return suivieDemande;
    }

    public void setSuivieDemande(SuivieDemandeEntity suivieDemande) {
        this.suivieDemande = suivieDemande;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}