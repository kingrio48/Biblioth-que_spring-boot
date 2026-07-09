package com.martinDev.Biblio_app.DataBase;

import com.martinDev.Biblio_app.Services.interfaces.BookService;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

    final private BookCommand bookCommand;
    final private BookService bookService;

    public CommandLineRunner(BookCommand bookCommand, BookService bookService){
        this.bookService = bookService;
        this.bookCommand = bookCommand;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookService.count() == 0){
            for (int i = 0; i <= 100; i++){
                bookCommand.save();
            }
        }
    }
}
