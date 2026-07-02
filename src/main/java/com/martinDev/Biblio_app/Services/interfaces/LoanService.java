package com.martinDev.Biblio_app.Services.interfaces;

import com.martinDev.Biblio_app.Dtos.LoanDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface LoanService {
    LoanDto createLoan(LoanDto loanDto);
    LoanDto updateLoan(UUID loanId, LoanDto loanDto);
    Optional<LoanDto> findLoanById(UUID loanId);
    List<LoanDto> findAllLoan();
    String deleteLoan(UUID loanId);
    String deletAllloan();
}
