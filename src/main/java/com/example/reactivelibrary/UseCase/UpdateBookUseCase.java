package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
@Validated
public class UpdateBookUseCase implements UpdateBook {
    LibraryRepository libraryRepository;
    BookMapper bookMapper;

    public UpdateBookUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Mono<BookDto> update(BookDto bookDto) {
        Objects.requireNonNull(bookDto.getId(), "El Id del objeto no puede ser nulo");
        return libraryRepository.save(bookMapper.mapToBook().apply(bookDto))
                .map(bookMapper.mapToDto());
    }
}
