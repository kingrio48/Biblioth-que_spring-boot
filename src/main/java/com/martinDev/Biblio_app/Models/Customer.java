package com.martinDev.Biblio_app.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.validator.constraints.pl.NIP;

import java.util.UUID;

@Entity
@Data
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "customer_id")
    private UUID customer_id;
    @Column(name = "name")
    private String name;
    @Column(name = "email", unique = true)
    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Fromat de l'email incorrect")
    private String email;
    @NotBlank(message = "Le numéro ne peut pas être vide")
    //@Pattern(regexp = "^\\d{9}$", message = "le numéro de téléphone doit avoir exactement 9 chiffres")
    @Column(unique = true)
    private String phone_number;
}
