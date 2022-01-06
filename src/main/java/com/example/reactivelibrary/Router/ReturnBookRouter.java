package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.UseCase.BorrowBookUseCase;
import com.example.reactivelibrary.UseCase.ReturnBookUseCase;
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
public class ReturnBookRouter {

    @Bean
    public RouterFunction<ServerResponse> returnBook(ReturnBookUseCase returnBookUseCase){
        return route(PUT("/libros/devolver/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(BodyInserters.fromPublisher(returnBookUseCase.returnBook(request.pathVariable("id")), String.class)));
    }

}
