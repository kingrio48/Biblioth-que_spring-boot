package com.martinDev.Biblio_app.Mappers;

import com.martinDev.Biblio_app.Dtos.BookDto;
import com.martinDev.Biblio_app.Models.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDto toBookDto(Book book);
    Book toBook(BookDto bookDto);
}
