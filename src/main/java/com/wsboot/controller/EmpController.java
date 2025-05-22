package com.wsboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
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
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import com.wsboot.entity.Empleado;
import com.wsboot.entity.Product;
import com.wsboot.repository.EmpleadoRepository;
import com.wsboot.service.EmpleadoService;


@EnableWebMvc
@RestController
public class EmpController {

    @Autowired
    EmpleadoRepository eRepository;

    
    @Autowired
    EmpleadoService eService;
 


	@GetMapping("/EmpsListToXML")
	//@RequestMapping(value = "/ProductsListPDF", method = RequestMethod.GET)
	//public  @ResponseBody String getProductListAngular(HttpServletRequest request, 
	public  @ResponseBody void EmpsListToXML(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {	
		String phtml="";
		String phtmlInicio="<html> <body> ";
		String phtmlMedio=" ";
		String phtmlFin="</body> </html>";
		
		
		try {		

			java.util.List <Empleado> eList = new java.util.ArrayList<Empleado>();
			eList = eService.empOrderByProvincia();
			XStream xstream = new XStream();
		    xstream.alias("empleado", Empleado.class);
		    //xstream.alias("persons", PersonList.class);
		    //xstream.addImplicitCollection(PersonList.class, "list");
		    
		    String xml = xstream.toXML(eList);
		    
			String json = new Gson().toJson(eList);
			//System.out.println(json);
			//System.out.println(eList);
     /*   for(Empleado e : eList) {
        	phtmlMedio=phtmlMedio+e.toString()+"<Br>";
        	
        	//System.out.println(e.toString());
        	 *  }
	        for(Empleado e : eList) {
	        	phtmlMedio = phtmlMedio +e;
	         //System.out.println(e.toString());
	        
	        }  	
       
       */   			
		

		 response.setContentType("text/xml");
		 PrintWriter out = response.getWriter();


	        System.out.println(xml);
	        out.println(xml);
	        
		 
		} catch (Exception e) {
			
			System.out.println(e);
		
		    throw new Exception(e);
		}
		//return phtml;		
	}		


	@GetMapping("/EmpsListToJSON")
	//@RequestMapping(value = "/ProductsListPDF", method = RequestMethod.GET)
	//public  @ResponseBody String getProductListAngular(HttpServletRequest request, 
	public  @ResponseBody void EmpsListToJson(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {	
		String phtml="";
		String phtmlInicio="<html> <body> ";
		String phtmlMedio=" ";
		String phtmlFin="</body> </html>";
		
		
		try {		

			java.util.List <Empleado> eList = new java.util.ArrayList<Empleado>();
			eList = eService.empOrderByProvincia();
			XStream xstream = new XStream();
		    xstream.alias("empleado", Empleado.class);
		    //xstream.alias("persons", PersonList.class);
		    //xstream.addImplicitCollection(PersonList.class, "list");
		    
		    String xml = xstream.toXML(eList);
		    
			String json = new Gson().toJson(eList);
			//System.out.println(json);
			//System.out.println(eList);
     /*   for(Empleado e : eList) {
        	phtmlMedio=phtmlMedio+e.toString()+"<Br>";
        	
        	//System.out.println(e.toString());
        	 *  }
	        for(Empleado e : eList) {
	        	phtmlMedio = phtmlMedio +e;
	         //System.out.println(e.toString());
	        
	        }  	
       
       */   			
		

		 response.setContentType("application/json");
		 PrintWriter out = response.getWriter();


	        
	        
            JSONObject xmlJSONObj = XML.toJSONObject(xml);
            
            String json2 = xmlJSONObj.toString(); //PRETTY_PRINT_INDENT_FACTOR);
            System.out.println(json2);
            out.println(json2);
            
	        //Object obj = (Object) json;
	        //System.out.println("obj "+obj);
		 
		} catch (Exception e) {
			
			System.out.println(e);
		
		    throw new Exception(e);
		}
		//return phtml;		
	}	
	
}
