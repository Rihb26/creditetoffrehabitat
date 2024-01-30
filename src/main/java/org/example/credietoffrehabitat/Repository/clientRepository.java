package org.example.credietoffrehabitat.Repository;

import org.example.credietoffrehabitat.Entity.clientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface clientRepository  extends JpaRepository<clientEntity,Long> {
    clientEntity findByEmail(String email);
}
