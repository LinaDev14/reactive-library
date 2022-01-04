package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.Model.Book;
import com.example.reactivelibrary.UseCase.CreateBookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CreateBookRouter {

    @Bean
    public RouterFunction<ServerResponse> createBook(CreateBookUseCase createBookUseCase){
        return route(POST("/libros/crear")
                .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(BookDto.class)
                .flatMap(createBookUseCase::apply)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result)
                )
        );
    }
}
