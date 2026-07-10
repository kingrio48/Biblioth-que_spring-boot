package com.martinDev.Biblio_app.Controllers;

import com.martinDev.Biblio_app.Dtos.CustomerDto;
import com.martinDev.Biblio_app.Services.interfaces.CustomersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    final private CustomersService customersService;


    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }
    @PostMapping
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        return customersService.createCustomer(customerDto);
    }
    @GetMapping
    public List<CustomerDto> findAllCustomers(){
        return customersService.findAllCustomer();
    }
    @GetMapping("/findCustomerById")
    public Optional<CustomerDto> findCustomerById(@RequestParam UUID customerId){
        return customersService.findCustomerById(customerId);
    }
    @PutMapping("/updateCustomer")
    public CustomerDto updateCustomer(@RequestParam UUID customerId, @RequestBody CustomerDto customerDto){
        return customersService.updateCustomer(customerId, customerDto);
    }
    @DeleteMapping("/deleteCustomerById")
    public String deleteCustomer(UUID customerId){
        return customersService.deleteCustomer(customerId);
    }
    @DeleteMapping("/deleteAllCustomer")
    public String deleteAllCustomer(){
        return customersService.deleteAllCustomer();
    }
}
