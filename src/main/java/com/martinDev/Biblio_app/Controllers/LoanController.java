package com.martinDev.Biblio_app.Controllers;

import com.martinDev.Biblio_app.Dtos.LoanDto;
import com.martinDev.Biblio_app.Services.interfaces.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/loans")
public class LoanController {
    final private LoanService loanService;

    public LoanController(LoanService loanService){
        this.loanService = loanService;
    }

    @PostMapping
    public LoanDto createLoan(LoanDto loanDto){
        return loanService.createLoan(loanDto);
    }
    @GetMapping("/findAllCustomer")
    public List<LoanDto> findAllLoan(){
        return loanService.findAllLoan();
    }
    @GetMapping("/findLoanVyId")
    public Optional<LoanDto> findLoanbyId(@RequestParam UUID loandId){
        return loanService.findLoanById(loandId);
    }
    @PutMapping("/updateLoan")
    public LoanDto updateLoan(@RequestParam UUID loanId, @RequestBody LoanDto loanDto){
        return loanService.updateLoan(loanId, loanDto);
    }
    @DeleteMapping("/deleteLoanById")
    public String deleteLoanById(UUID loanId){
        return loanService.deleteLoan(loanId);
    }
    @DeleteMapping("/deleteAllLoan")
    public String deleteAllLoan(){
        return loanService.deletAllloan();
    }
}
