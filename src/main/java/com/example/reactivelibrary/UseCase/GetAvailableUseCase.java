package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
@Validated
public class GetAvailableUseCase implements Function<String, Flux<BookDto>>{

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public GetAvailableUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Flux<BookDto> apply(String available) {
        if(available.equals("true") ||  available.equals("false")){
            return libraryRepository.findAll()
                    .filter(book -> book.getAvailable().equals(Boolean.valueOf(available)))
                    .map(book -> bookMapper.mapToDto().apply(book));
        }
        return Flux.error(new ResponseStatusException(HttpStatus.BAD_REQUEST, "parametro erroneo"));
    }
}
