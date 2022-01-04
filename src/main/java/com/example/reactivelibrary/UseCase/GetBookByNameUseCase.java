package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class GetBookByNameUseCase implements GetBookByName{

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public GetBookByNameUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public Flux<BookDto> getByName(String name) {
        return libraryRepository.findAll()
                .filter(book -> book.getName().toLowerCase().replace(" ", "")
                        .contains(name.toLowerCase().replace(" ", "")))
                .map(bookMapper.mapToDto());
    }
}
