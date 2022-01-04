package com.example.reactivelibrary.Router;

import com.example.reactivelibrary.DTO.BookDto;
import com.example.reactivelibrary.DTO.NameDto;
import com.example.reactivelibrary.UseCase.UpdateBookNameUseCase;
import com.example.reactivelibrary.UseCase.UpdateBookUseCase;
import org.bson.types.ObjectId;
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
public class UpdateBookNameRouter {
    
    @Bean
    public RouterFunction<ServerResponse> updateBook(UpdateBookNameUseCase updateBookNameUseCase) {
        return route(PUT("/libros/nuevoNombre={id}")
                .and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(NameDto.class)
                        .flatMap(response -> updateBookNameUseCase.updateName(request.pathVariable("id"), response.getName())
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        )
        );
    }
}
