package com.example.reactivelibrary.Repository;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LibraryRepository extends ReactiveMongoRepository<Book, String> {
}
