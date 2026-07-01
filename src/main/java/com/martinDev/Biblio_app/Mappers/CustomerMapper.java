package com.martinDev.Biblio_app.Mappers;

import com.martinDev.Biblio_app.Dtos.CustomerDto;
import com.martinDev.Biblio_app.Models.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDto toCustomerDto(Customer customer);
    Customer toCustomer(CustomerDto customerDto);
}
