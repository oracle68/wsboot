package com.wsboot.controller;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.wsboot.entity.Book;
import com.wsboot.entity.Item;
import com.wsboot.entity.Persona;
import com.wsboot.entity.Empleado;
import com.wsboot.entity.LobTable;
import com.wsboot.entity.PdfTable;

import com.wsboot.service.BookService;
import com.wsboot.service.BookService2;
import com.wsboot.service.ItemService;
import com.wsboot.service.PersonaService;
import com.wsboot.service.EmpleadoService;
import com.wsboot.service.LobTableService;
import com.wsboot.service.PdfTableService;

import com.wsboot.util.WriteToFile;

@CrossOrigin(origins = "http://localhost:9999/")
@RestController
public class BookController2 {
	@Autowired
	BookService2 bookService2;
	

    @GetMapping("/books")
    public List<Book> findAll(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "ASC") String sortDirection) {
        Page<Book> result = bookService2.findAll(pageNo, pageSize, sortBy, sortDirection);
        return result.getContent();

    } 	
    @GetMapping("/bookPage")
    public void findAllPage(HttpServletRequest request, HttpServletResponse response) 
    		throws Exception {
    	//List<Book>
    	System.out.println("llega1");

        
       
	PrintWriter out = response.getWriter();
	response.setContentType("text/html");
	System.out.println("llega2");
	try {

    	int pageNo = 2; 
        int pageSize = 10;
        String sortBy = "id";
        String sortDirection = "ASC";
    	
        Page<Book> result = bookService2.findAll(pageNo, pageSize, sortBy, sortDirection);
       // return result.getContent();
        System.out.println("size "+result.getSize());
        
		for (Book  r: result)
		{	
		 out.println(r.toString()+"<br>");
		// System.out.println(r.toString());
		}
		        

    } catch (Exception e) {
		System.out.println(e);
	   
		System.out.println("llega3");	    
	}	  

	//return "OK";
    }

    
	
}
