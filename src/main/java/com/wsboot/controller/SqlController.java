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
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


import com.wsboot.entity.Item;
import com.wsboot.entity.Product;
import com.wsboot.repository.ProvinciaRepository;
import com.wsboot.service.ItemService;

import com.wsboot.entity.Provincia;
import com.wsboot.service.ProvinciaService;
import com.wsboot.util.ClobToString;
import com.wsboot.util.ColumnNames;

import org.hibernate.SessionFactory;

@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class SqlController {

    
    @Autowired
    EntityManager entityManager;
 


	
	@RequestMapping(value = "/execSql", method = RequestMethod.GET)
	public  @ResponseBody void ExecSqlCommand(@RequestParam String sql,HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();
		
		try {

	
			 response.setContentType("text/html");
			 out.println("query: "+sql+"<br>");	
			List<Object[]> query =  entityManager
				    .createNativeQuery(sql)
				   // .getSingleResult();
				    .getResultList();
			for (Object[] result: query)
			{	
			 out.println(result[0]+"<br>");
			}
			
/*
	
Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a WHERE a.id = ?");
q.setParameter(1, 1);
Object[] author = (Object[]) q.getSingleResult();
 
System.out.println("Author "
        + author[0]
        + " "
        + author[1]); 
 */
        
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			
			List<String[]> query =  entityManager
				    .createNativeQuery(sql)
				   // .getSingleResult();
				    .getResultList();
			for (String[] result: query)
			{	
			 out.println(result[0]+"<br>");
			}			
		    
		}	    

		
	}	
	

	@RequestMapping(value = "/execSqlTable", method = RequestMethod.GET)
	@Transactional
	public  @ResponseBody void ExecSqlTableCommand(@RequestParam String table,HttpServletRequest request, 
	        HttpServletResponse response) throws Exception {
		PrintWriter out = response.getWriter();

		try {

			
			java.sql.Clob q = (java.sql.Clob) entityManager
				    .createNativeQuery(
				        "SELECT tabletoxml(:tabla) FROM DUAL"
				    )
				    .setParameter("tabla", table)
				    .getSingleResult();			

		ClobToString cts = new ClobToString();
		response.setContentType("text/xml");
		out.println(cts.clobToString(q));

		//entityManager.getTransaction().begin();
		
		//SessionFactory sessionFactory = entityManager.unwrap(SessionFactory.class);
		
		//ColumnNames cn = new ColumnNames();
		//cn.columnNames(sessionFactory,"Empleados");		
		//entityManager.getTransaction().commit();
		
		} catch (Exception e) {
			System.out.println(e);
		}	    

		
	}	
}
