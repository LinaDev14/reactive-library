package com.example.reactivelibrary.UseCase;

import com.example.reactivelibrary.Mapper.BookMapper;
import com.example.reactivelibrary.Repository.LibraryRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class BorrowBookUseCase {

    private final LibraryRepository libraryRepository;
    private final BookMapper bookMapper;

    public BorrowBookUseCase(LibraryRepository libraryRepository, BookMapper bookMapper){
        this.libraryRepository = libraryRepository;
        this.bookMapper = bookMapper;
    }



}
