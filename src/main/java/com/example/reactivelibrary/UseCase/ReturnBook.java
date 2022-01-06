package com.example.reactivelibrary.UseCase;

import reactor.core.publisher.Mono;

public interface ReturnBook {
    public Mono<String> returnBook(String id);
}
