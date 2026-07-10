package com.martinDev.Biblio_app.DataBase;

import com.martinDev.Biblio_app.Services.interfaces.BookService;
import com.martinDev.Biblio_app.Services.interfaces.CustomersService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    final private BookCommand bookCommand;
    final private BookService bookService;
    final private CustomersService customersService;
    final private CustomerCommand customerCommand;

    public CommandLineRunner(BookCommand bookCommand, BookService bookService, CustomersService customersService, CustomerCommand customerCommand){
        this.bookService = bookService;
        this.bookCommand = bookCommand;
        this.customersService = customersService;
        this.customerCommand = customerCommand;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookService.count() == 0){
            for (int i = 0; i <= 100; i++){
                bookCommand.save();
            }
        }
        if(customersService.count() == 0){
            for (int i = 0; i <= 100; i++){
                customerCommand.save();
            }
        }
    }
}
