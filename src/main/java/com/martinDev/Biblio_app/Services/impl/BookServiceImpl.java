package com.martinDev.Biblio_app.Services.impl;

import com.martinDev.Biblio_app.Dtos.BookDto;
import com.martinDev.Biblio_app.Mappers.BookMapper;
import com.martinDev.Biblio_app.Models.Book;
import com.martinDev.Biblio_app.Repositories.BookRepository;
import com.martinDev.Biblio_app.Services.interfaces.BookService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    final BookRepository bookRepository;
    final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    private BookDto save(BookDto bookDto) {
        Book book =  bookMapper.toBook(bookDto);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toBookDto(savedBook);
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        return save(bookDto);
    }

    @Override
    public BookDto updateBook(UUID book_id, BookDto bookDto) {
        Optional<BookDto> bookOptional = this.findBookById(book_id);
        BookDto newbookDto = null;
        if (bookOptional.isPresent()) {
            newbookDto = bookOptional.get();
            if (bookDto.getTitle() != null) {
                newbookDto.setTitle(bookDto.getTitle());
            }
            if (bookDto.getNbrDisponible() != null) {
                newbookDto.setNbrTotal(bookDto.getNbrDisponible());
            }
            if (bookDto.getNbrTotal() != null) {
                newbookDto.setNbrTotal(bookDto.getNbrTotal());
            }
            return save(newbookDto);
        }
        return null;
    }

    @Override
    public BookDto getBookById(UUID book_id) {
        return null;
    }

    @Override
    public List<BookDto> findallBooks() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDto> findBookById(UUID book_id) {
        Optional<Book> bookOptional = bookRepository.findById(book_id);
        return bookOptional.map(book -> BookDto.builder()
                .book_id(book.getBook_id())
                .title(book.getTitle())
                .nbrDisponible(book.getNbrDisponible())
                .nbrTotal(book.getNbrTotal())
                .build());
    }

    @Override
    public String deleteBookById(UUID book_id) {
        bookRepository.deleteById(book_id);
        return "Votre livre à été suprimé avec succès";
    }

    @Override
    public String deleteAllBooks() {
        bookRepository.deleteAll();
        return "La liste des livre a été supprimé avec succès";
    }
}
