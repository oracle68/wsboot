package com.wsboot.controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
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

import com.wsboot.entity.Empleado;
import com.wsboot.repository.EmpleadoRepository;
import com.wsboot.service.EmpleadoService;



@EnableWebMvc
@RestController
public class EmpleadoController2 {

    @Autowired
    EmpleadoRepository eRepository;

    
    @Autowired
    EmpleadoService eService;

    @Autowired
    EntityManager entityManager;
    
	@GetMapping("/EmpsListProvincia")
	public  @ResponseBody void EmpListProvincia(HttpServletRequest request,
	        HttpServletResponse response) throws Exception {
		 PrintWriter out = response.getWriter();
		 response.setContentType("text/html");
		try {	

			List <String> provList = (List <String>) entityManager
				    .createNativeQuery(
				        "SELECT nom FROM provincia"
				    )
				    //.setParameter("tabla", table)
				    .getResultList();	
			
	        for(String p : provList) {
	        	out.println("Provincia: "+p+"<br>");
				java.util.List <Empleado> empList = (java.util.List <Empleado>) entityManager
					    .createQuery(
					        "SELECT e FROM com.wsboot.entity.Empleado e where e.provincia =:prov order by e.provincia"
					    )
					    .setParameter("prov", p.toString())
					    .getResultList();		        	
				for(Empleado e : empList) {
					out.println(e.toString2()+"<br>");
				}
				
	        }  			
				
	        
		
		} catch (Exception e) {
			
			System.out.println(e);
		
		    throw new Exception(e);
		}
}
	

	
}
