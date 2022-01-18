package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Enums.BookType;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import com.example.reactivelibrary.UseCase.CreateBookUseCase;
import com.example.reactivelibrary.UseCase.GetAvailableUseCase;
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
import reactor.core.publisher.Flux;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {GetAvailableRouter.class, GetAvailableUseCase.class, BookMapper.class})
class GetAvailableRouterTest {

    @MockBean
    private LibraryRepository libraryRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void GetAvailableTest(){

        Book book = new Book();
        book.setId("xxx");
        book.setName("name");
        book.setBookType(BookType.cuento);
        book.setAvailable(true);
        book.setLastBorrowed(Date.from(Instant.now()));

        Flux<Book> bookFlux = Flux.just(book);

        Mockito.when(libraryRepository.findAll()).thenReturn(bookFlux);

        webTestClient.get()
                .uri("/libros/get_available/true")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BookDto.class)
                .value(response ->{
                    Assertions.assertEquals(response.get(0).getId(), book.getId());
                    Assertions.assertEquals(response.get(0).getName(), book.getName());
                    Assertions.assertEquals(response.get(0).getBookType(), book.getBookType());
                    Assertions.assertEquals(response.get(0).getAvailable(), book.getAvailable());

                });
    }

}