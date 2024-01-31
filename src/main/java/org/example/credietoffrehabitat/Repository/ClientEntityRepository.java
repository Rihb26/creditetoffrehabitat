package org.example.credietoffrehabitat.Repository;

import org.example.credietoffrehabitat.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<ClientEntity, Long> {

    ClientEntity findByEmail(String email);

}