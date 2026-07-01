package com.martinDev.Biblio_app.Dtos;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class BookDto {

    private UUID book_id;

    private String title;

    private Integer nbrDisponible;

    private Integer nbrTotal;
}
