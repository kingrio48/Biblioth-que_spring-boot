package com.martinDev.Biblio_app.Models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID user_id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    @NotBlank(message = "L'email ne peut pas être vide")
    @Email(message = "Format de l'email invalide")
    private String email;
    @Column(name = "phone_number")
    @NotBlank(message = "Le numéro est obligatoire")
    @Pattern(regexp = "^\\d{9}$", message = "Le numéro doit avoir exactement 9 chiffres")
    private String phone_number;
    private String password;

}
