package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import reactor.core.publisher.Flux;

@FunctionalInterface
public interface GetBookByName {
    Flux<BookDto> getByName(String name);
}
