package com.example.reactivelibrary.Model;

import com.example.reactivelibrary.Enums.BookType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("reactiveLibrary")
public class Book {

    @Id
    private String id;
    private String name;
    private BookType bookType;
    private Boolean available;
    private Date lastBorrowed;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Date getLastBorrowed() {
        return lastBorrowed;
    }

    public void setLastBorrowed(Date lastBorrowed) {
        this.lastBorrowed = lastBorrowed;
    }
}
