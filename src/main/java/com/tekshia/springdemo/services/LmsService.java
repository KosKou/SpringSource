package com.tekshia.springdemo.services;

import com.tekshia.springdemo.entities.Book;
import com.tekshia.springdemo.repository.LmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Service annotation define
@Service
public class LmsService {
    //Init Object dependency
    @Autowired
    private LmsRepository lmsRepository;
//    Books Finding
    public Collection<Book> findAllBooks(){
        List<Book> books = new ArrayList<Book>();
        for (Book book: lmsRepository.findAll()          ) {
            books.add(book);
        }
        return books;
    }
//    Book Delete
    public void deleteBook(long id){
        lmsRepository.deleteById(id);
    }
//    Book Finding
    public Book findBookById(long id){
        return lmsRepository.findById(id).get();
    }
//    Save & Update Book
    //This could be use for update and insert methods
    public void save(Book book){
        lmsRepository.save(book);
    }
}
