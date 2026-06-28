package com.martinDev.Biblio_app.Models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID loanId;
    @Column(name = "date_emprunt")
    private Date dateEmprunt;
    @Column(name = "date_retour_estimer")
    private Date dateRetourEstimer;
    @Column(name = "date_retour")
    private Date dateRetour;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
