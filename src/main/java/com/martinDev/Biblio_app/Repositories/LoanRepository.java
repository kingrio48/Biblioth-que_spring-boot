package com.martinDev.Biblio_app.Repositories;

import com.martinDev.Biblio_app.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRepository extends JpaRepository<Loan, UUID> {
}
