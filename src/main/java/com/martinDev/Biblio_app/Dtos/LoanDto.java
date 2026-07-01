package com.martinDev.Biblio_app.Dtos;


import com.martinDev.Biblio_app.Models.Book;
import com.martinDev.Biblio_app.Models.Customer;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class LoanDto {

    private UUID loanId;

    private Date dateEmprunt;

    private Date dateRetourEstimer;

    private Date dateRetour;

    private Customer customer;

    private Book book;
}
