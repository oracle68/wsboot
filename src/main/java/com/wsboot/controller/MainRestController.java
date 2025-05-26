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

    
	@GetMapping("/form")
	public void  getForm ( HttpServletRequest request, 
	        HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
				
			 String nom = (String) request.getAttribute("nom");
			 String edad = (String) request.getAttribute("edad");
			 
			 response.setContentType("text/html");
			 out.println("parametros: <br>");	
			// out.println("Atrib name "+ +"<br>");
			// out.println("Atrib age "+request.getAttribute("age") +"<br>");
			 
			 out.println("nom "+nom+"<br>");	
			 out.println("edad "+edad+"<br>");
			 
  
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			
		}	
		
	}
	
	@GetMapping("/form2")
	public void  getForm2 ( HttpServletRequest request, 
	        HttpServletResponse response,@FormParam("nom") String nom,
		    @FormParam("edad") String edad) throws IOException {
		
		PrintWriter out = response.getWriter();
		
		try {
				
			// String name = (String) request.getAttribute("name");
			// String age = (String) request.getAttribute("age");
			 
			 response.setContentType("text/html");
			 out.println("parametros: <br>");	
			// out.println("Atrib name "+ +"<br>");
			// out.println("Atrib age "+request.getAttribute("age") +"<br>");
			 
			 out.println("nom "+nom+"<br>");	
			 out.println("edad "+edad+"<br>");
			 
  
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			
		}	
		
	}
	

	
	
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
	
	
	@GetMapping("/empOrderByProvincia")
	public List <Empleado> empOrderByProvincia() {
		
		List <Empleado> empleadosList = empleadoService.empOrderByProvincia();
		return empleadosList;
	}	

	
	@RequestMapping(value="/getpdf", method=RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	//public ResponseEntity<byte[]> getPDF(@RequestBody java.util.List lista) {
	//public String getPDF(@RequestBody java.util.List<Empleado> lista2) {
	public String getPDF(@RequestBody Collection <Empleado> lista2) {
	    // convert JSON to Employee 
		String filename = "c:/temp/lista.pdf";
		System.out.println("begin");
		//java.util.List lista2 = lista; //new ArrayList<>();
		
		 try {
		      FileWriter myWriter = new FileWriter(filename);
		      for (int i = 0; i < lista2.size(); i++) {
		    	  myWriter.write(((HttpHeaders) lista2).get(i).toString()+"\n"); //  System.out.println(names.get(i));
		    	}		      
		      
		      myWriter.close();
		      //System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	    // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
	  /*  byte[] contents  =  (byte[]) lista2;

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_PDF);
	    // Here you have to set the actual filename of your pdf
	   // String filename = "/temp/_output.pdf";
	    headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
	    */
	    return  "OK!";
	}
	
	@PostMapping("/putListToPdf")
	public void putListToPdf(@PathVariable java.util.List lista)  {
		
		String filename = "c:/temp/lista.pdf";
		System.out.println("1lista.size() "+lista.size());
	try {
		System.out.println("2lista.size() "+lista.size());		
		WriteToFile wtf = new WriteToFile();
		wtf.escriuLista(filename,lista);
		System.out.println("end ");
		//return new ModelAndView("personasPagsList","pList", pList);
	   }catch(Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();            
       }	
	System.out.println("OK");		
	}	
	
	@GetMapping("/ListToPdf") //, produces = {"text/plain", "application/*"}))
	
	//public void ListToPdf(@RequestParam("filename") String filename,
    //        @RequestParam("lista") java.util.List lista)  {
	public void getListToPdf(@PathVariable java.util.List lista)  {
			
		String filename = "c:/temp/lista.pdf";
		System.out.println("1lista.size() "+lista.size());
	try {
		System.out.println("2lista.size() "+lista.size());		
		WriteToFile wtf = new WriteToFile();
		wtf.escriuLista(filename,lista);
		System.out.println("end ");
		//return new ModelAndView("personasPagsList","pList", pList);
	   }catch(Exception e){
           System.out.println(e.getMessage());
           e.printStackTrace();            
       }	
	System.out.println("OK");		
	}		
}
