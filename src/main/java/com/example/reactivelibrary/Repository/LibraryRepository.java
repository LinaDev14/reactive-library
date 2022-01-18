package com.example.reactivelibrary.Repository;


import com.example.reactivelibrary.Model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface LibraryRepository extends ReactiveMongoRepository<Book, String> {
}
