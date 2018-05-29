package com.tekshia.springdemo.entities;

/*
* Developed by @Banner Gonzales -> KosKou
*
* How Does it works?
*
* Runtime Line: Repository->Service->Controller->Entity->View
*
* PostMan Line: Repository->Service->RestController->Entity->JSON File
*
* This Project use:
* -SpringBoot
* -JPA
* -Web
* -Thymeleaf
* */

import javax.persistence.*;
import java.util.Date;

//Here we describe the table name we're going to create or update
@Entity(name = "lms_tbl")
public class Book {

    //Annotions to perform the table and column, alter table at id to be auto increment
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "book_name")
    private String bookName;

    private String author;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    //Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
