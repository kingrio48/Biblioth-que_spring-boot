package com.martinDev.Biblio_app.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserDto {
    private UUID user_id;
    private String name;
    private String email;
    private String phone_number;
}
