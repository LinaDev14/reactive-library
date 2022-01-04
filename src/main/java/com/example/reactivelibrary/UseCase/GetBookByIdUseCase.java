package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class GetBookByIdUseCase implements GetBookById{

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public GetBookByIdUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Mono<BookDto> get(String id) {
        return libraryRepository
                .findById(id)
                .map(bookMapper::fromModel);
    }
}
