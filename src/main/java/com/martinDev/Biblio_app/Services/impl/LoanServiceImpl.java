package com.martinDev.Biblio_app.Services.impl;

import com.martinDev.Biblio_app.Dtos.LoanDto;
import com.martinDev.Biblio_app.Mappers.LoanMapper;
import com.martinDev.Biblio_app.Models.Loan;
import com.martinDev.Biblio_app.Repositories.LoanRepository;
import com.martinDev.Biblio_app.Services.interfaces.LoanService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class LoanServiceImpl implements LoanService {

    final LoanRepository loanRepository;
    final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper){
        this.loanMapper = loanMapper;
        this.loanRepository = loanRepository;
    }

    public LoanDto save(LoanDto loanDto){
        Loan loan = loanMapper.toLoan(loanDto);
        Loan loansaved = loanRepository.save(loan);
        return loanMapper.toLoanDto(loansaved);
    }

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        return save(loanDto);
    }

    @Override
    public LoanDto updateLoan(UUID loanId, LoanDto loanDto) {
        Optional<LoanDto> loanDtoVerified = findLoanById(loanId);
        if (loanDtoVerified.isPresent()){
            LoanDto newLoan = loanDtoVerified.get();
            if (loanDto.getLoanId() != null){
                loanDto.setLoanId(newLoan.getLoanId());
            }
            if(loanDto.getBook() != null){
                loanDto.setBook(newLoan.getBook());
            }
            if (loanDto.getCustomer() != null){
                loanDto.setCustomer(newLoan.getCustomer());
            }
            if(loanDto.getDateEmprunt() != null){
                loanDto.setDateEmprunt(newLoan.getDateEmprunt());
            }
            if(loanDto.getDateRetourEstimer() != null){
                loanDto.setDateRetourEstimer(newLoan.getDateRetourEstimer());
            }
            if(loanDto.getDateRetour() != null){
                loanDto.setDateRetour(newLoan.getDateRetour());
            }
            return loanDto;
        }
        return null;
    }

    @Override
    public Optional<LoanDto> findLoanById(UUID loanId) {
        Optional<Loan> loanOptional = loanRepository.findById(loanId);
        return loanOptional.map(loan -> LoanDto.builder()
                .loanId(loan.getLoanId())
                .customer(loan.getCustomer())
                .book(loan.getBook())
                .dateEmprunt(loan.getDateEmprunt())
                .dateRetour(loan.getDateRetour())
                .dateRetourEstimer(loan.getDateRetourEstimer())
                .build());
    }

    @Override
    public List<LoanDto> findAllLoan() {
        List<Loan> loanList = loanRepository.findAll();
        return loanList.stream()
                .map(loanMapper::toLoanDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteLoan(UUID loanId) {
        loanRepository.deleteById(loanId);
        return "Le prêt a été supprimé avec succès";
    }

    @Override
    public String deletAllloan() {
        loanRepository.deleteAll();
        return "Tous les prêts ont été supprimé avec succès";
    }
}
