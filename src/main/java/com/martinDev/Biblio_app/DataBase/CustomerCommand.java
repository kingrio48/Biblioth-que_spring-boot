package com.martinDev.Biblio_app.DataBase;

import com.martinDev.Biblio_app.Dtos.CustomerDto;
import com.martinDev.Biblio_app.Services.interfaces.CustomersService;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomerCommand {
    final private CustomersService customersService;
    final private Faker faker;
    final private Random random;

    public CustomerCommand(CustomersService customersService){
        this.customersService = customersService;
        this.faker = new Faker();
        this.random = new Random();
    }

    public void save(){
        String name = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().phoneNumber();
        CustomerDto customerDto = CustomerDto.builder()
                .name(name)
                .email(email)
                .phone_number(phone)
                .build();
        this.customersService.createCustomer(customerDto);
    }
}
