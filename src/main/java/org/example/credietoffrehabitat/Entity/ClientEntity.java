package org.example.credietoffrehabitat.Entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="clients")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "client")
    private Set<SimulationPretEntity> simulationPrets;

    @ManyToMany
    @JoinTable(
            name = "client_nouveaute_banque",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns = @JoinColumn(name = "nouveaute_banque_id"))
    private Set<NouveauteBanqueEntity> nouveauteBanques;

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }
}
