package com.example.reactivelibrary.Mapper;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Model.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Function<BookDto, Book> mapToBook(){
        return bookDto -> {
            var book = new Book();
            book.setName(bookDto.getName());
            book.setBookType(bookDto.getBookType());
            book.setAvailable(bookDto.getAvailable());
            book.setLastBorrowed(bookDto.getLastBorrowed());
            return book;
        };
    }

    public Function<Book, BookDto> mapToDto(){
        return book ->
            new BookDto(
                    book.getId(),
                    book.getName(),
                    book.getBookType(),
                    book.getAvailable(),
                    book.getLastBorrowed()
            );
    }

    public Book fromDto(BookDto bookDto){
        Book book = new Book();
        book.setId(bookDto.getId());
        book.setName(bookDto.getName());
        book.setBookType(bookDto.getBookType());
        book.setAvailable(bookDto.getAvailable());
        book.setLastBorrowed(bookDto.getLastBorrowed());
        return book;
    }

    public BookDto fromModel(Book book){
        return new BookDto(
                book.getId(),
                book.getName(),
                book.getBookType(),
                book.getAvailable(),
                book.getLastBorrowed()
        );
    }

    public List<BookDto> fromModelList(List<Book> bookList){
        if(bookList == null){
            return null;
        }
        return bookList.stream().map(this::fromModel).collect(Collectors.toList());
    }
}
