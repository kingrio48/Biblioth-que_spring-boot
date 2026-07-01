package com.martinDev.Biblio_app.Dtos;


import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CustomerDto {

    private UUID customer_id;

    private String name;

    private String email;

    private String phone_number;
}

