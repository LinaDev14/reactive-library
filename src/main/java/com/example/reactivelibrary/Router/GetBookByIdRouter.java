package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.UseCase.GetBookByIdUseCase;
import com.example.reactivelibrary.UseCase.GetBookByNameUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBookByIdRouter {

    @Bean
    public RouterFunction<ServerResponse> getBookById(GetBookByIdUseCase getBookByIdUseCase){
        return route(GET("/libros/id={id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(getBookByIdUseCase
                                .get(request.pathVariable("id")), BookDto.class))
        );
    }
}
