package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateBookNameUseCase implements UpdateBookName{

    LibraryRepository libraryRepository;
    BookMapper bookMapper;

    public UpdateBookNameUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Mono<BookDto> updateName(String id, String name) {
        Mono<Book> bookToUpdate = libraryRepository.findById(id);
        return bookToUpdate.flatMap(book ->{
            BookDto updatedDto = bookMapper.updateNameDto(bookMapper.mapToDto().apply(book), name);
            return libraryRepository.save(bookMapper.mapToBook().apply(updatedDto)).map(b -> bookMapper.mapToDto().apply(b));
        });
    }
}
