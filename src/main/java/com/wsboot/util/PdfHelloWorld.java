package com.wsboot.util;

import java.io.FileWriter;
import java.io.IOException;
import com.wsboot.util.PDFObject; 
public class PdfHelloWorld {

		
		public static void main(String[] args) throws IOException {
	 
			/**
			 * Create font object with times roman font & give it name as F1.
			 */
			PDFObject fontName = new PDFObject("Font");
			fontName.addKey("Subtype", "/Type1");
			fontName.addKey("BaseFont", "/Times-Roman");
			PDFObject font = new PDFObject("Font", new PDFObject("F1", fontName));
	 
			/**
			 * Create text object with above font with size 18 & coordinate position (10,10)
			 * with text "Hello World"
			 */
			PDFObject text = new PDFObject(4, 0);
			text.addKey("Length", Integer.toString("Hello World".getBytes().length));
			text.addTextStream("F1", 18, 10, 50, "Hello World");
	 
			/**
			 * Create page object with above font & text
			 */
			PDFObject page = new PDFObject(3, 0, "Page");
			page.addObjectReferenceKey("Resources", font);
			page.addObjectReferenceKey("Contents", text);
	 
			/**
			 * Create pages object with above page.
			 */
			PDFObject pages = new PDFObject(2, 0, "Pages");
			pages.addKey("Count", "1");
			pages.addKey("MediaBox", "[0 0 300 144]");
			pages.addObjectReferenceArrayKey("Kids", page);
	 
			page.addObjectReferenceKey("Parent", pages);
	 
			/**
			 * Create root object wrapping pages object.
			 */
			PDFObject root = new PDFObject(1, 0, "Catalog");
			root.addObjectReferenceKey("Pages", pages);
	 
			/**
			 * Create PDF with abvoe root & all of the objects
			 */
			PDF pdf = new PDF(root, pages, page, text);
	 
			/**
			 * Write PDF to a file.
			 */
			FileWriter fileWriter = new FileWriter("c:/temp/generatedPDF.pdf");
			fileWriter.write(pdf.build());
			fileWriter.close();
	 
			System.out.println("Done");
		}

}
