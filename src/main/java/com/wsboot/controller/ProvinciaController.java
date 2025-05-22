package com.wsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
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

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;


import com.wsboot.entity.Item;
import com.wsboot.entity.Product;
import com.wsboot.repository.ProvinciaRepository;
import com.wsboot.service.ItemService;

import com.wsboot.entity.Provincia;
import com.wsboot.service.ProvinciaService;



@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class ProvinciaController {

    @Autowired
    ProvinciaService provService;
    
    @Autowired
    EntityManager entityManager;
    
	@RequestMapping(value = "/ExisteProvincia", method = RequestMethod.GET)
	public  @ResponseBody HttpStatus ExisteProvincia(HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		try {
			
		   // @Query(nativeQuery = true, value = "SELECT INSERT_PROVINCIA(:text) FROM dual");
		   // String callFunction(@Param("text") String text);	
			//provService.callInsertProvincia("Valencia");
			//provService.callFuncInsertProvincia("Alacant");
			
			String q = (String) entityManager
				    .createNativeQuery(
				        "SELECT fn_existe_provincia(:provname) FROM DUAL"
				    )
				    .setParameter("provname", "Alacant")
				    .getSingleResult();			
			System.out.println(q);
			
			if (q.equals("OK"))  return HttpStatus.OK;
			else return HttpStatus.BAD_REQUEST;
        
		} catch (Exception e) {
			System.out.println(e);
		    return HttpStatus.BAD_REQUEST; //throw new Exception(e);
		    
		    
		}	    
		
	}	

	@RequestMapping(value = "/CreaProvincia", method = RequestMethod.GET)
	public  @ResponseBody HttpStatus CreaProvincia(@RequestParam String nomProvincia, HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		try {
			
		   // @Query(nativeQuery = true, value = "SELECT INSERT_PROVINCIA(:text) FROM dual");
		   // String callFunction(@Param("text") String text);	
			provService.callInsertProvincia(nomProvincia);
			
			
/*			String q = (String) entityManager
				    .createNativeQuery(
				        "SELECT (:provname) FROM DUAL"
				    )
				    .setParameter("provname", "Alacant")
				    .getSingleResult();			
			System.out.println(q);
			
			if (q.equals("OK"))  return HttpStatus.OK;
			else return HttpStatus.BAD_REQUEST;
**/        
		} catch (Exception e) {
			System.out.println(e);
		    return HttpStatus.BAD_REQUEST; //throw new Exception(e);
		    
		    
		}	
		
		return HttpStatus.OK;		
		
	}	
    	
}
