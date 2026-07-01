package com.martinDev.Biblio_app.Repositories;

import com.martinDev.Biblio_app.Dtos.BookDto;
import com.martinDev.Biblio_app.Models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, UUID> {
}
