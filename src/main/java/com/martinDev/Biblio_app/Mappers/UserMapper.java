package com.martinDev.Biblio_app.Mappers;

import com.martinDev.Biblio_app.Dtos.UserDto;
import com.martinDev.Biblio_app.Models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toUserDto(User user);
    User toUser(UserDto userDto);
}
