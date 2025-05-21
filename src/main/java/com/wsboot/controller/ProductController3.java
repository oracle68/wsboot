package com.wsboot.controller;

import java.io.FileOutputStream;
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

import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;


import com.wsboot.entity.Product;
import com.wsboot.service.ProductService;

@Controller
public class ProductController3 {

	@Autowired
	private ProductService productService;      

	@RequestMapping(value = "/ProductsListPDF2", method = RequestMethod.GET)
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
        String path = "c:/temp/tableProducts.pdf";
        System.out.println("0");
        PdfWriter pdfwriter = new PdfWriter(path);
        System.out.println("01");
        // Creating a PdfDocument object.
        // passing PdfWriter object constructor of
        // pdfDocument.
        PdfDocument pdfdocument
            = new PdfDocument(pdfwriter);
        System.out.println("1");	
  
        PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 ,1});
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell("Id");
            table.addCell("Name");
            table.addCell("Description");
            table.addCell("Price");
        table.setHeaderRows(1);
        PdfPCell[] cells = table.getRow(0).getCells(); 
        for (int j=0;j<cells.length;j++){
           cells[j].setBackgroundColor(BaseColor.GRAY);
        }
        
        for(Product p : productList) {
            //System.out.println(p.toString());
        	table.addCell(p.getId()+"");
        	table.addCell(p.getName()+"");
        	table.addCell(p.getDescription()+"");
        	table.addCell(p.getPrice()+"");
        }  	        

        com.itextpdf.text.Document document2=new com.itextpdf.text.Document();
        com.itextpdf.text.pdf.PdfWriter.getInstance(document2, new FileOutputStream("c:/temp/tableProducts.pdf"));
        
        document2.open();
            document2.add(table);
        document2.close();        
        
        // Creating a Document and passing pdfDocument
        // object
            /*  
        document.add(itemsList);
        */
        System.out.println("end");
        // Closing the document
            System.out.println(
            "List has been successfully added to the file :"
            + path);
        
		} catch (Exception e) {
		    throw new Exception(e);
		}	    
		return HttpStatus.OK;
	}		
	
}