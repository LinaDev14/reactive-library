package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class CreateBookUseCase implements CreateBook{
    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    @Autowired
    public CreateBookUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Mono<BookDto> apply(BookDto bookDto){
        return libraryRepository
                .save(bookMapper.mapToBook()
                .apply(bookDto))
                .map(bookMapper.mapToDto());
    }
}
