package com.martinDev.Biblio_app.Services.interfaces;

import com.martinDev.Biblio_app.Dtos.BookDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(UUID book_id,BookDto bookDto);
    BookDto getBookById(UUID book_id);
    List<BookDto> findallBooks();
    Optional<BookDto> findBookById(UUID book_id);
    String deleteBookById(UUID book_id);
    String deleteAllBooks();
}
