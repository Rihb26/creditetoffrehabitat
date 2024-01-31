package org.example.credietoffrehabitat.Service;


import org.example.credietoffrehabitat.Entity.Role;
import org.example.credietoffrehabitat.Entity.ClientEntity;
import org.example.credietoffrehabitat.Repository.RoleRepository;
import org.example.credietoffrehabitat.Repository.ClientEntityRepository;
import org.example.credietoffrehabitat.dto.ClientDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientEntityRepository clientEntityRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientEntityRepository clientEntityRepository,
                             RoleRepository roleRepository,
                             PasswordEncoder passwordEncoder) {
        this.clientEntityRepository = clientEntityRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(ClientDto clientDto) {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(clientDto.getFirstName() + " " + clientDto.getLastName());
        clientEntity.setEmail(clientDto.getEmail());
        // encrypt the password using spring security
        clientEntity.setPassword(passwordEncoder.encode(clientDto.getPassword()));

        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        clientEntity.setRoles(Arrays.asList(role));
        clientEntityRepository.save(clientEntity);
    }

    @Override
    public ClientEntity findUserByEmail(String email) {
        return clientEntityRepository.findByEmail(email);
    }

    @Override
    public List<ClientDto> findAllUsers() {
        List<ClientEntity> clientEntities = clientEntityRepository.findAll();
        return clientEntities.stream()
                .map((user) -> mapToUserDto(user))
                .collect(Collectors.toList());
    }

    private ClientDto mapToUserDto(ClientEntity clientEntity){
        ClientDto clientDto = new ClientDto();
        String[] str = clientEntity.getName().split(" ");
        clientDto.setFirstName(str[0]);
        clientDto.setLastName(str[1]);
        clientDto.setEmail(clientEntity.getEmail());
        return clientDto;
    }

    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}