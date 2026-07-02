package com.martinDev.Biblio_app.Services.interfaces;

import com.martinDev.Biblio_app.Dtos.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(UUID userId, UserDto userDto);
    Optional<UserDto> findUserById(UUID userId);
    List<UserDto> findAllUser();
    String deleteUser(UUID userId);
    String deletAllUser();
}
