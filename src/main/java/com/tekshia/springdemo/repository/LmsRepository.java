package com.tekshia.springdemo.repository;

import com.tekshia.springdemo.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Repository Annotations & CRUD
@Repository
public interface LmsRepository extends CrudRepository<Book,Long> {

}
