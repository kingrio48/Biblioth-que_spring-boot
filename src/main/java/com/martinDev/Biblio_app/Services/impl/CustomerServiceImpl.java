package com.martinDev.Biblio_app.Services.impl;

import com.martinDev.Biblio_app.Dtos.CustomerDto;
import com.martinDev.Biblio_app.Mappers.CustomerMapper;
import com.martinDev.Biblio_app.Models.Customer;
import com.martinDev.Biblio_app.Repositories.CustomerRepository;
import com.martinDev.Biblio_app.Services.interfaces.CustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomersService {
    final CustomerRepository customerRepository;
    final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository){
        this.customerMapper = customerMapper;
        this.customerRepository = customerRepository;
    }

    public CustomerDto save(CustomerDto customerDto){
        Customer customer = customerMapper.toCustomer(customerDto);
        Customer customerSaved = customerRepository.save(customer);
        return customerMapper.toCustomerDto(customerSaved);
    }
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return save(customerDto);
    }

    @Override
    public CustomerDto updateCustomer(UUID customer_id, CustomerDto customerDto) {
        Optional<CustomerDto> customerOptional = findCustomerById(customer_id);
        CustomerDto newCustomer = null;
        if (customerOptional.isPresent()){
            newCustomer = customerOptional.get();
            if(customerDto.getCustomer_id() != null){
                customerDto.setCustomer_id(newCustomer.getCustomer_id());
            }
            if(customerDto.getName() != null){
                customerDto.setName(newCustomer.getName());
            }
            if(customerDto.getEmail() != null){
                customerDto.setEmail(newCustomer.getEmail());
            }
            if(customerDto.getPhone_number() != null){
                customerDto.setPhone_number(newCustomer.getPhone_number());
            }
            return customerDto;
        }
        return null;
    }

    @Override
    public Optional<CustomerDto> findCustomerById(UUID customer_id) {
        Optional<Customer> customerDtoOptional = customerRepository.findById(customer_id);
        return customerDtoOptional.map(customer -> CustomerDto.builder()
                .customer_id(customer.getCustomer_id())
                .name(customer.getName())
                .phone_number(customer.getPhone_number())
                .email(customer.getEmail())
                .build());
    }

    @Override
    public List<CustomerDto> findAllCustomer() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteCustomer(UUID customer_id) {
        customerRepository.deleteById(customer_id);
        return "Le client à été supprimé avec succès";
    }

    @Override
    public String deleteAllCustomer() {
        customerRepository.deleteAll();
        return "La liste des clients a été supprimé ";
    }
}
