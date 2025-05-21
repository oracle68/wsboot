package com.wsboot.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.AreaBreak;

import com.wsboot.entity.Product;
import com.wsboot.service.ProductService;

@Controller
public class ProductController2 {

	@Autowired
	private ProductService productService;      


	
	@RequestMapping(value = "/ProductsListPDF", method = RequestMethod.GET)
	public  @ResponseBody HttpStatus getProductListAngular(HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		try {
		/*	 PrintWriter out = response.getWriter();	
		response.setContentType("application/pdf");
		
	    String s = new String();
        for(Product p : productList) {
            //System.out.println(p.toString());
            s = s + p.toString();
        }  	
	    
        out.println(s);
        */
			java.util.List<Product> productList = productService.findAllOrderById();			
        // path where the pdf is to be created.
        String path = "C:/temp/productList.pdf";
        System.out.println("0");
        PdfWriter pdfwriter = new PdfWriter(path);
        System.out.println("01");
        // Creating a PdfDocument object.
        // passing PdfWriter object constructor of
        // pdfDocument.
        PdfDocument pdfdocument
            = new PdfDocument(pdfwriter);
        System.out.println("1");	
        
        // Creating a list
        List list = new List();
        
        for(Product p : productList) {
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
        
		} catch (Exception e) {
		    throw new Exception(e);
		}	    
		return HttpStatus.OK;
	}		
	
}