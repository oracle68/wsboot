package com.wsboot.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wsboot.entity.Book;
import com.wsboot.repository.BookRepository;
import com.wsboot.service.BookService;

@CrossOrigin(origins = "http://localhost:9999")
@EnableWebMvc
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    
    @Autowired
    BookService bookService;
    
    public void setBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}


	@RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseStatus(value=HttpStatus.OK)
    public List<Book> getAllBooks() {
    	System.out.println("*****************************getAllBooks");
    	List<Book> lista = this.bookRepository.findAll();
    	for (Book var:lista) {
    		System.out.println(var.toString());
    	}
        return lista;
    }


    @RequestMapping(value = "/addbook3/{autor}/{titulo}/{descripcion}/{fecha}", method = RequestMethod.POST)
           //, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    //HttpServletRequest httpServletRequest,
    public Book addBook(@PathVariable String autor,
    					@PathVariable String titulo,
    					@PathVariable String price,
    					@PathVariable String fecha)
    {
    	Book book = new Book(); 
    	book.setId(1L);
    	book.setAutor(autor);
    	book.setTitulo(titulo);
    	
    	book.setPrice(new BigDecimal(price));
    	
    	System.out.println(book.toString());
        return this.bookService.addBook(book);
    }

    @RequestMapping(value = "/addbook2", method = RequestMethod.POST)
    //, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public Book addBook2(@RequestBody Book book) {
	book.setId(1L);
	System.out.println(book.toString());
 return this.bookService.addBook(book);
}

    @RequestMapping(value = "/updatebook", method = RequestMethod.PUT)
            //consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Book updateBook(@RequestBody Book book) {
        return this.bookService.updateBook(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return this.bookService.getBookById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        this.bookService.deleteAllBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable Long id) {
        this.bookService.deleteBookById(id);
    }



}    