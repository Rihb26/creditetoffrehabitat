package org.example.credietoffrehabitat.Service;

import org.example.credietoffrehabitat.Entity.User;
import org.example.credietoffrehabitat.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
