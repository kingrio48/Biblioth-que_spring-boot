package com.martinDev.Biblio_app.DataBase;

import com.martinDev.Biblio_app.Dtos.BookDto;
import com.martinDev.Biblio_app.Services.interfaces.BookService;
import net.datafaker.Faker;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookCommand {
    final private BookService bookService;
    final private Faker faker;
    final private Random random;

    public BookCommand(BookService bookService){
        this.bookService = bookService;
        this.faker = new Faker();
        this.random = new Random();
    }

    public void save(){
        String faketitle = faker.book().title();
        Integer totalBook = random.nextInt(100) + 1;
        Integer disponibleBooks = random.nextInt(totalBook + 1);
        BookDto bookDto = BookDto.builder()
                .title(faketitle)
                .nbrDisponible(disponibleBooks)
                .nbrTotal(totalBook)
                .build();
        this.bookService.createBook(bookDto);
    }
}
