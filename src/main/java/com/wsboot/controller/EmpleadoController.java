package com.wsboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.wsboot.entity.Empleado;
import com.wsboot.entity.Product;
import com.wsboot.repository.EmpleadoRepository;
import com.wsboot.service.EmpleadoService;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.AreaBreak;

@EnableWebMvc
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoRepository eRepository;

    
    @Autowired
    EmpleadoService eService;
 

	@GetMapping("/EmpsListProv")
	//@RequestMapping(value = "/ProductsListPDF", method = RequestMethod.GET)
	//public  @ResponseBody String getProductListAngular(HttpServletRequest request, 
	public  @ResponseBody void getProductListAngular(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {	
		String phtml="";
		String phtmlInicio="<html> <body> ";
		String phtmlMedio=" ";
		String phtmlFin="</body> </html>";
		
		
		try {		

			java.util.List <Empleado> eList = eService.empOrderByProvincia();
		
        for(Empleado e : eList) {
        	phtmlMedio=phtmlMedio+e.toString()+"<Br>";
        	//System.out.println(e.toString());
        }  			
		

		 //response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 response.setContentType("application/pdf");

	        String path = "C:/temp/eList.pdf";
	        System.out.println("0");
	        PdfWriter pdfwriter = new PdfWriter(path);
	        System.out.println("01");
	        // Creating a PdfDocument object.
	        // passing PdfWriter object constructor of
	        // pdfDocument.
	        PdfDocument pdfdocument  = new PdfDocument(pdfwriter);
	        System.out.println("1");	
	        
	        
	        // Creating a list
	        List list = new List();
	        
	        for(Empleado p : eList) {
	            //System.out.println(p.toString());
	        	list.add( p.toString());
	        }  	
	        
	        // Creating a Document and passing pdfDocument
	        // object
	        Document document = new Document(pdfdocument);
	        System.out.println("2");
	        //List <Item> itemsList = new ArrayList<>();  //
				//itemsList = itemService.findAll(); 

	       // com.itextpdf.txt.List a = new com.itextpdf.text.List();
	   
	       /* com.itextpdf.layout.element.List a = new com.itextpdf.layout.element.List();
	        */
	        

	        
	        // Adding list to the document
	        document.add( list);
	        /*  
	        document.add(itemsList);
	        */
	        System.out.println("end");
	        // Closing the document
	        document.close();
	        System.out.println(
	            "List has been successfully added to the file :"
	            + path);
		 
		/* ByteArrayOutputStream stream = new ByteArrayOutputStream();
		 //Json.createWriter(stream).write(eList);

		 byte[] sendData = stream.toByteArray();
		 
		phtml = phtmlInicio+phtmlMedio+phtmlFin;
		response.getWriter().println(sendData);
*/
		 
		} catch (Exception e) {
			
			System.out.println(e);
		
		    throw new Exception(e);
		}
		//return phtml;		
	}	
	

	
}
