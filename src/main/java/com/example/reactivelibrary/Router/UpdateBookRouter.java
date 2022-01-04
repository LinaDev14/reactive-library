package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.UseCase.UpdateBookUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdateBookRouter {

    @Bean
    public RouterFunction<ServerResponse> updateBook(UpdateBookUseCase updateBookUseCase){
        return route(PUT("/libros/actualizar")
                        .and(accept(MediaType.APPLICATION_JSON)), request -> request.bodyToMono(BookDto.class)
                .flatMap(updateBookUseCase::update)
                .flatMap(result -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(result))
        );
    }
}
