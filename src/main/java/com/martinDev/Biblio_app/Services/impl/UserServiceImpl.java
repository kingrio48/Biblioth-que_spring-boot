package com.martinDev.Biblio_app.Services.impl;

import com.martinDev.Biblio_app.Dtos.UserDto;
import com.martinDev.Biblio_app.Mappers.UserMapper;
import com.martinDev.Biblio_app.Models.User;
import com.martinDev.Biblio_app.Repositories.UserRepository;
import com.martinDev.Biblio_app.Services.interfaces.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    final UserMapper userMapper;
    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper ){
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }
    public UserDto save(UserDto userDto){
        User user = userMapper.toUser(userDto);
        User userSaved = userRepository.save(user);
        return userMapper.toUserDto(userSaved);
    }
    @Override
    public UserDto createUser(UserDto userDto) {
        return save(userDto);
    }

    @Override
    public UserDto updateUser(UUID userId, UserDto userDto) {
        Optional<UserDto> userVerified = findUserById(userId);
        if (userVerified.isPresent()){
            UserDto newUser = userVerified.get();
            if(userDto.getUser_id() != null){
                userDto.setUser_id(newUser.getUser_id());
            }
            if(userDto.getName() != null){
                userDto.setName(newUser.getName());
            }
            if (userDto.getEmail() != null){
                userDto.setEmail(newUser.getEmail());
            }
            if(userDto.getPhone_number() != null){
                userDto.setPhone_number(newUser.getPhone_number());
            }
        }
        return null;
    }

    @Override
    public Optional<UserDto> findUserById(UUID userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.map(user -> UserDto.builder()
                .user_id(user.getUser_id())
                .name(user.getName())
                .email(user.getEmail())
                .phone_number(user.getPhone_number())
                .build());
    }

    @Override
    public List<UserDto> findAllUser() {
        return userRepository.findAll().stream()
                .map(userMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteUser(UUID userId) {
        userRepository.findById(userId);
        return "L'utilisateur est à été supprimé avec succès";
    }

    @Override
    public String deletAllUser() {
        userRepository.findAll();
        return "La liste des utilisateur a été supprimé";
    }
}
