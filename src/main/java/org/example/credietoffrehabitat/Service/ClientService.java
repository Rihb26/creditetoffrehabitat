package org.example.credietoffrehabitat.Service;

import org.example.credietoffrehabitat.Entity.ClientEntity;
import org.example.credietoffrehabitat.dto.ClientDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface ClientService {
    void saveUser(ClientDto clientDto);

    ClientEntity findUserByEmail(String email);

    List<ClientDto> findAllUsers();
}
