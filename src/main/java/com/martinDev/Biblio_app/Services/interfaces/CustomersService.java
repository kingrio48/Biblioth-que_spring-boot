package com.martinDev.Biblio_app.Services.interfaces;

import com.martinDev.Biblio_app.Dtos.CustomerDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomersService {
    CustomerDto createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(UUID customer_id ,CustomerDto customerDto);
    Optional<CustomerDto> findCustomerById(UUID customer_id);
    List<CustomerDto> findAllCustomer();
    String deleteCustomer(UUID customer_id);
    String deleteAllCustomer();
}
