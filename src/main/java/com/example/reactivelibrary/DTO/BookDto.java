package com.example.reactivelibrary.DTO;

import java.util.Date;
import java.util.Objects;

public class BookDto {

    private String id;
    private String name;
    private String bookType;
    private Boolean available;
    private Date lastBorrowed;

    public BookDto(){

    }

    public BookDto(String name, String bookType, Boolean available, Date lastBorrowed){
        this.name = name;
        this.bookType = bookType;
        this.available = available;
        this.lastBorrowed = lastBorrowed;
    }

    public BookDto(String id, String name, String bookType, Boolean available, Date lastBorrowed){
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
