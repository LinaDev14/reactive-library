package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Enums.BookType;
import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.Repository.LibraryRepository;
import com.example.reactivelibrary.UseCase.CreateBookUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.sql.Date;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {CreateBookRouter.class, CreateBookUseCase.class, BookMapper.class})
class CreateBookRouterTest {

    @MockBean
    private LibraryRepository libraryRepository;

    @Autowired
    private WebFluxTest webFluxTest;

    @Test
    public void createBookTest(){
        BookDto bookDto = new BookDto();
        bookDto.setId("xxx");
        bookDto.setName("name");
        bookDto.setBookType(BookType.cuento);
        bookDto.setAvailable(true);
        bookDto.setLastBorrowed(Date.from(Instant.now()));
    }

}