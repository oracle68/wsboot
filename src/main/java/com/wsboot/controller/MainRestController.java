package com.wsboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsboot.entity.Book;
import com.wsboot.entity.Item;
import com.wsboot.entity.Persona;
import com.wsboot.entity.Empleado;
import com.wsboot.service.BookService;
import com.wsboot.service.ItemService;
import com.wsboot.service.PersonaService;
import com.wsboot.service.EmpleadoService;

@CrossOrigin(origins = "http://localhost:9999")
@RestController
public class MainRestController {

	@Autowired
	ItemService itemService;

	@Autowired
	PersonaService userService;
	
	@Autowired
	BookService bookService;	

	@Autowired
	EmpleadoService  empleadoService;	
	
	@GetMapping("/itemsList")
	public List <Item>  getItemsList() {
		
		List <Item> itemsList = itemService.findAll(); 
		return itemsList;
	}
	

	@GetMapping("/usersList")
	public List <Persona> getUsersList() {
		
		List <Persona> usersList = userService.findAll(); 
		return usersList;
	}	
	
	@GetMapping("/booksList")
	public List <Book> getBooksList() {
		
		List <Book> booksList = bookService.getAllBooks();
		return booksList;
	}		

	@GetMapping("/empleadosList")
	public List <Empleado> findAllEmpleados() {
		
		List <Empleado> empleadosList = empleadoService.findAll();
		return empleadosList;
	}	
}
