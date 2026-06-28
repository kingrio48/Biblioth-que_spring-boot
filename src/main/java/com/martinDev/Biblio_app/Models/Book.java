package com.martinDev.Biblio_app.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID book_id;
    private String title;
    @Column(name = "nbr_disponible")
    private int nbrDisponible;
    @Column(name = "nbr_total")
    private int nbrTotal;

}
