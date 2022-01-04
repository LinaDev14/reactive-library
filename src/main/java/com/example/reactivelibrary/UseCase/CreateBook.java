package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Model.Book;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface CreateBook {
    public Mono<BookDto> apply(BookDto bookDto);
}
