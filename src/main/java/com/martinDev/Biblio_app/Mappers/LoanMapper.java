package com.martinDev.Biblio_app.Mappers;

import com.martinDev.Biblio_app.Dtos.LoanDto;
import com.martinDev.Biblio_app.Models.Loan;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanDto toLoanDto(Loan loan);
    Loan toLoan(LoanDto loanDto);
}
