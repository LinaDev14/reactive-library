package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import reactor.core.publisher.Mono;

public interface UpdateBook {
    public Mono<BookDto> update(BookDto bookDto);
}
