package org.example.credietoffrehabitat.security;

import org.example.credietoffrehabitat.Entity.ClientEntity;
import org.example.credietoffrehabitat.Entity.Role;
import org.example.credietoffrehabitat.Repository.ClientEntityRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class CustomClientDetailsService implements UserDetailsService {
    private ClientEntityRepository clientEntityRepository;

    public CustomClientDetailsService(ClientEntityRepository clientEntityRepository) {
        this.clientEntityRepository = clientEntityRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        ClientEntity clientEntity = clientEntityRepository.findByEmail(email);

        if (clientEntity != null) {
            return new org.springframework.security.core.userdetails.User(clientEntity.getEmail(),
                    clientEntity.getPassword(),
                    mapRolesToAuthorities(clientEntity.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection< ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
