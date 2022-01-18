package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class BorrowBookUseCase implements BorrowBook{

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public BorrowBookUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public Mono<String> borrowBook(String id) {
        Mono<Book> book = libraryRepository.findById(id);
        return book.flatMap( b -> {
            if (b.getAvailable().equals(true)) {
                return libraryRepository.save(bookMapper.mapToBook()
                                .apply(bookMapper.setAvalable(false)
                                        .apply(bookMapper.mapToDto().apply(b))))
                        .thenReturn("Prestado");
            }
            return Mono.just("no disponible");
        }
        );
    }
}
