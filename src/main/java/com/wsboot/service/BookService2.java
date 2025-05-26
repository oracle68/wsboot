package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Book;
import com.wsboot.repository.BookRepository;


@Service
public class BookService2 {

	    @Autowired
	    BookRepository bookDao;


	    public Page<Book> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
	        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
	        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

	        return bookDao.findAll(pageable);	   
	    }

}