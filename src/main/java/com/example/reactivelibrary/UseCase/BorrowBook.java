package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import reactor.core.publisher.Mono;


public interface BorrowBook {
    public Mono<String> borrowBook(String id);
}
