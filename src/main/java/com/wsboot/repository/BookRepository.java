package com.wsboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wsboot.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	
}
