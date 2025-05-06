package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Book;
import com.wsboot.repository.BookRepository;


@Service
public class BookService {

	    @Autowired
	    BookRepository bookDao;

	    public List<Book> getAllBooks() {
	        return this.bookDao.findAll();
	    }

	    public Book addBook(Book book) {
	        return this.bookDao.save(book);
	    }

	    //other methods go here


	    public Book getBookById(Long id) {
	        return this.bookDao.getOne(id);
	    }

	    public Book updateBook(Book book) {
	        return this.bookDao.save(book);
	    }

	    public void deleteBookById(Long id) {
	        this.bookDao.deleteById(id);
	    }

	    public void deleteAllBooks() {
	        this.bookDao.deleteAll();
	    }

}