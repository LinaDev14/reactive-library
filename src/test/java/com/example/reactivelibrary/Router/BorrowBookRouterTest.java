package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Enums.BookType;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import com.example.reactivelibrary.UseCase.BorrowBookUseCase;
import com.example.reactivelibrary.UseCase.GetBookByIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BorrowBookRouter.class, BorrowBookUseCase.class, BookMapper.class})
class BorrowBookRouterTest {

    @MockBean
    private LibraryRepository libraryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void BorrowBookTest(){

        Book book = new Book();
        book.setId("xxx");
        book.setName("name");
        book.setBookType(BookType.cuento);
        book.setAvailable(true);
        book.setLastBorrowed(Date.from(Instant.now()));

        Mono<Book> bookMono = Mono.just(book);

        Mockito.when(libraryRepository.findById("xxx")).thenReturn(bookMono);
        Mockito.when(libraryRepository.save(any())).thenReturn(bookMono);

        webTestClient.put()
                .uri("/libros/prestar/xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(response ->{
                    Assertions.assertEquals("Prestado", response);
                });

        book.setAvailable(false);

        Mono<Book> bookMono1 = Mono.just(book);

        Mockito.when(libraryRepository.findById("xxx")).thenReturn(bookMono1);
        Mockito.when(libraryRepository.save(any())).thenReturn(bookMono1);

        webTestClient.put()
                .uri("/libros/prestar/xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(response ->{
                    Assertions.assertEquals("no disponible", response);
                });

    }
}