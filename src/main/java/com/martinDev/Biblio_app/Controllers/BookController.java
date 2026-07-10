package com.martinDev.Biblio_app.Controllers;

import com.martinDev.Biblio_app.Dtos.BookDto;
import com.martinDev.Biblio_app.Services.interfaces.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
    final private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }
    @GetMapping
    public List<BookDto> findAllBook(){
        return bookService.findallBooks();
    }
    @PutMapping("/update")
    public BookDto updateBook(@RequestParam UUID BookId, @RequestBody BookDto bookDto){
        return bookService.updateBook(BookId, bookDto);
    }
    @GetMapping("/findById")
    public Optional<BookDto> findBookById(@RequestParam UUID bookId){
        return bookService.findBookById(bookId);
    }
    @DeleteMapping("/deleteById")
    public String deleteBookById(@RequestParam UUID bookId){
        return bookService.deleteBookById(bookId);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAll(BookService bookService){
        return bookService.deleteAllBooks();
    }
}
