package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.UseCase.BorrowBookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BorrowBookRouter {

    @Bean
    public RouterFunction<ServerResponse> borrowBook(BorrowBookUseCase borrowBookUseCase){
        return route(PUT("/libros/prestar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(BodyInserters.fromPublisher(borrowBookUseCase.borrowBook(request.pathVariable("id")), String.class)));
    }

}
