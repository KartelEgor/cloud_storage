package ru.netology.cloud_storage.service;

import ru.netology.cloud_storage.DTO.TokenDTO;
import ru.netology.cloud_storage.DTO.UserDTO;
import ru.netology.cloud_storage.entity.UserDAO;

import java.util.Optional;

public interface UserService {

    String login(UserDTO user);

    Optional<UserDAO> findByToken(TokenDTO token);

    void logout(String token);
}
