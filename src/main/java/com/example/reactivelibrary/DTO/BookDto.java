package com.example.reactivelibrary.DTO;

import com.example.reactivelibrary.Enums.BookType;
import java.util.Date;

public class BookDto {

    private String id;
    private String name;
    private BookType bookType;
    private Boolean available;
    private Date lastBorrowed;

    public BookDto(){

    }

    public BookDto(String name, BookType bookType, Boolean available, Date lastBorrowed){
        this.name = name;
        this.bookType = bookType;
        this.available = available;
        this.lastBorrowed = lastBorrowed;
    }

    public BookDto(String id, String name, BookType bookType, Boolean available, Date lastBorrowed){
        this.id = id;
        this.name = name;
        this.bookType = bookType;
        this.available = available;
        this.lastBorrowed = lastBorrowed;
    }

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
