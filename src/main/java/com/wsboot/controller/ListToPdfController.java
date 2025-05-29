package com.wsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.wsboot.entity.Empleado;
import com.wsboot.entity.Item;
import com.wsboot.entity.Product;
import com.wsboot.repository.ProvinciaRepository;
import com.wsboot.service.EmpleadoService;
import com.wsboot.service.ItemService;

import com.wsboot.entity.Provincia;
import com.wsboot.service.ProvinciaService;
import com.wsboot.util.ClobToString;
import com.wsboot.util.ColumnNames;
import com.wsboot.util.WritePdf;

//import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.json.JSONObject;
import org.json.XML;




@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class ListToPdfController {

    
    @Autowired
    EntityManager entityManager;

    @Autowired
    EmpleadoService eService;
    
	
	@RequestMapping(value = "/ListToPdf2", method = RequestMethod.GET)
	public  @ResponseBody void ListToPdf2Command( String tabla,HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		try {
			/*			System.out.println("user.home "+ System.getProperty("user.home"));
			//System.out.println("File.separator  "+ System.getProperty("File.separator"));
			
			// response.setContentType("text/html");
			
				java.sql.Clob q = (java.sql.Clob) entityManager
					    .createNativeQuery(
					        "SELECT tabletoxml(:tabla) FROM DUAL"
					    )
					    .setParameter("tabla", tabla)
					    .getSingleResult();			

			ClobToString cts = new ClobToString();
			//response.setContentType("text/xml");
			//out.println(cts.clobToString(q));

			response.setContentType("application/pdf");
			
			//String html="<object src=\"YourFile.pdf\" type=\"application/pdf\" title=\"SamplePdf\" width=\"500\" height=\"720\">>"+cts.clobToString(q)+"</object>"; 
			String html2=cts.clobToString(q);

		//byte[] a = new byte[] {html};
			byte[] data = IOUtils.toByteArray(q.getAsciiStream());
			StringBuilder buffer = new StringBuilder();
		    for(int i = 0; i < data.length;i++){
		    buffer.append(data[i]);
		    }
		    char[] c = buffer.toString().toCharArray();
		

	
			out.write(c);
		*/
			
			java.util.List <Empleado> eList = new java.util.ArrayList<Empleado>();
			eList = eService.empOrderByProvincia();
			/*XStream xstream = new XStream();
		    xstream.alias("empleado", Empleado.class);
		    //xstream.alias("persons", PersonList.class);
		    //xstream.addImplicitCollection(PersonList.class, "list");
		    
		    String xml = xstream.toXML(eList);
		    
			String json = new Gson().toJson(eList);
			 response.setContentType("application/pdf");


	        
	        
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            
            String json2 = xmlJSONObj.toString();
            */
			String html="";
			for (Empleado e: eList)
			{	
			  html=html+e.toString()+"\n";
			}
			WritePdf wpdf = new WritePdf();
			
			 wpdf.writePdf(html);
			
			
	/*		java.util.List <Empleado> eList = new java.util.ArrayList<Empleado>();
			eList = eService.empOrderByProvincia();
			XStream xstream = new XStream();
		    xstream.alias("empleado", Empleado.class);
		    //xstream.alias("persons", PersonList.class);
		    //xstream.addImplicitCollection(PersonList.class, "list");
	    
		    String xml = xstream.toXML(eList);
*/			    
			
/*			String outputFolder = System.getProperty("user.home") +"\\thymeleaf.pdf";	

			OutputStream outputStream = new FileOutputStream(outputFolder);
			String url = new File(html).toURI().toURL().toString();
		    ITextRenderer renderer = new ITextRenderer();
		    renderer.setDocument(url);
		    renderer.layout();
		    renderer.createPDF(outputStream);

		    outputStream.close();
*/		    
		    
   
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			

		    
		}	    

		
	}	
	
}
