package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class ReturnBookUseCase implements ReturnBook{

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public ReturnBookUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Mono<String> returnBook(String id) {
        Mono<Book> book = libraryRepository.findById(id);
        return book.flatMap( b -> {
                    if (b.getAvailable().equals(false)) {
                        return libraryRepository.save(bookMapper.mapToBook()
                                        .apply(bookMapper.setAvalable(true)
                                                .apply(bookMapper.mapToDto().apply(b))))
                                .thenReturn("Devuelto");
                    }
                    return Mono.just("ya se encuentra en la biblioteca");
                }
        );
    }
}
