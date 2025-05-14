package com.wsboot.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wsboot.entity.Book;
import com.wsboot.entity.Item;
import com.wsboot.entity.Persona;
import com.wsboot.entity.Empleado;
import com.wsboot.entity.LobTable;
import com.wsboot.entity.PdfTable;

import com.wsboot.service.BookService;
import com.wsboot.service.ItemService;
import com.wsboot.service.PersonaService;
import com.wsboot.service.EmpleadoService;
import com.wsboot.service.LobTableService;
import com.wsboot.service.PdfTableService;

import com.wsboot.util.WriteToFile;

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

	@Autowired
	LobTableService  lobTableService;	

	@Autowired
	PdfTableService  pdfTableService;	
	
	@GetMapping("/itemsList")
	public List <Item>  getItemsList() {
		
		List <Item> itemsList = itemService.findAll(); 
		WriteToFile w  = new WriteToFile();
		w.escriuLista("C:/temp/itemsList.pdf", itemsList);
				
		return itemsList;
	}
	

	@GetMapping("/usersList")
	public List <Persona> getUsersList() {
		
		List <Persona> usersList = userService.findAll(); 
		return usersList;
	}	
	
	
	@GetMapping("/LobsList")
	public List <LobTable> getLobsList() {
		
		List <LobTable> lobsList = lobTableService.findAllLobs(); 
		return lobsList;
	}		
	
	@GetMapping("/PdfsList")
	public List <PdfTable> getPdfsList() throws IOException {
		
		List <PdfTable> pdfsList = pdfTableService.findAllPdfs(); 
		
		
	    for (int i = 0; i < pdfsList.size(); i++) {
	    	OutputStream outfile = new FileOutputStream("c:/temp/outfile_"+i+".pdf");	    	
	        outfile.write(pdfsList.get(i).getDataBlob());      
	        outfile.close();
	    }
		
		
		return pdfsList;
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
