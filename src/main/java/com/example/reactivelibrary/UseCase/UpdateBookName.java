package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import org.bson.types.ObjectId;
import reactor.core.publisher.Mono;

public interface UpdateBookName {
    public Mono<BookDto> updateName(String id, String name);
}
