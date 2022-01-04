package com.example.reactivelibrary.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("reactiveLibrary")
public class Book {

    @Id
    private String id;
    private String name;
    private String bookType;
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

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
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
