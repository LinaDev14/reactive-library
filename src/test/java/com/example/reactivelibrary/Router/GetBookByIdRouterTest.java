package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Enums.BookType;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
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

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetBookByIdRouter.class, GetBookByIdUseCase.class, BookMapper.class})
class GetBookByIdRouterTest {

    @MockBean
    private LibraryRepository libraryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void GetBookByIdTest(){

        Book book = new Book();
        book.setId("xxx");
        book.setName("name");
        book.setBookType(BookType.cuento);
        book.setAvailable(true);
        book.setLastBorrowed(Date.from(Instant.now()));

        Mono<Book> bookMono = Mono.just(book);

        Mockito.when(libraryRepository.findById("xxx")).thenReturn(bookMono);

        webTestClient.get()
                .uri("/libros/id/xxx")
                .exchange()
                .expectStatus().isOk()
                .expectBody(BookDto.class)
                .value(response ->{
                    Assertions.assertEquals(response.getId(), book.getId());
                    Assertions.assertEquals(response.getName(), book.getName());
                    Assertions.assertEquals(response.getBookType(), book.getBookType());
                    Assertions.assertEquals(response.getAvailable(), book.getAvailable());

                });
    }

}