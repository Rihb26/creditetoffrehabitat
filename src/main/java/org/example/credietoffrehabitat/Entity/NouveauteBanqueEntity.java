package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;
@Entity
public class NouveauteBanqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String image;
    private Date datePublication;
    private String contenu;
    private String titre;
    private String auteur;

    @ManyToMany(mappedBy = "nouveauteBanques")
    private Set<ClientEntity> clients;
}
