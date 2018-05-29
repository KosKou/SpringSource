package com.tekshia.springdemo.controllers.rest;

import com.tekshia.springdemo.entities.Book;
import com.tekshia.springdemo.services.LmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

//RestController Annotation
@RestController
public class MainRestController {
    @Autowired
    LmsService lmsService;

    /* --Testing
    @GetMapping("/")
    public String hello(){
        return "heyDude";
    }
    */

//    PostMan JSON config

    @GetMapping("/books")
    public Collection<Book> findAllBooks(){
        return lmsService.findAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book findBookById(@PathVariable long id){
        return lmsService.findBookById(id);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id){
        lmsService.deleteBook(id);
    }
}
