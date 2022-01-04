package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GetBookById {
    Mono<BookDto> get(String id);
}
