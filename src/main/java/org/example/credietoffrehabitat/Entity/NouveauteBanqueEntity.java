package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Entity
@Table(name = "nouveauteBanque")
public class NouveauteBanqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private Date datePublication;
    @Column(name = "contenu", columnDefinition = "TEXT")
    private String contenu;
    private String titre;
    private String auteur;

    @ManyToMany(mappedBy = "nouveauteBanques")
    private Set<ClientEntity> clients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Set<ClientEntity> getClients() {
        return clients;
    }

    public void setClients(Set<ClientEntity> clients) {
        this.clients = clients;
    }

}
