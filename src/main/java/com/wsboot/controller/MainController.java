package com.wsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;


import com.wsboot.entity.Item;
import com.wsboot.repository.EmpleadoRepository;
import com.wsboot.service.ItemService;

import com.wsboot.entity.Empleado;
import com.wsboot.service.EmpleadoService;



@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class MainController {

    @Autowired
    ItemService itemService;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    EmpleadoRepository empleadoRepository;
    
	@GetMapping("/index")
	public ModelAndView getIndex() {
		
		return new ModelAndView("index");
	}

	
	@GetMapping("/menu")
	public ModelAndView getMenu() {
		
		return new ModelAndView("menu");
	}
	

	@GetMapping("/formulario")
	public ModelAndView getForm() {
		
		return new ModelAndView("formulario");
	}
	
	@PostMapping("/form")
	public void  postForm(HttpServletRequest request, 
	        HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("Method POST <br>");
		try {

			
			 String nom = (String) request.getParameter("nom");
			 String edad = (String) request.getParameter("edad");
			 
			 
			 out.println("parametros: <br>");	

			 
			 out.println("nom "+nom+"<br>");	
			 out.println("edad "+edad+"<br>");
  
		} catch (Exception e) {
			System.out.println(e);
		    //throw new Exception(e);
			
		}	
		
	}


	
	@GetMapping("/itemsListAngularPDF")
	public String getItemsListAngularPDF() {
		return "itemsListAngularPDF";
	}

	@GetMapping("/itemsListGrid")
	public String getItemsListGrid() {
		return "itemsListGrid";
	}

	@GetMapping("/itemsListGrid2")
	public String getItemsListGrid2() {
		return "itemsListGrid2";
	}
	
	@GetMapping("/itemsListGrid3")
	public String getItemsListGrid3() {
		return "itemsListGrid3";
	}

	@GetMapping("/itemsTreeList3")
	public String getItemsTreeList3() {
		return "itemsTreeList3";
	}
	
	@GetMapping("/testGrid")
	public String testGrid() {
		return "testGrid";
	}	
	
	@GetMapping("/booksListAngular")
	public String getBooksListAngular() {
		return "booksListAngular";
	}
	
	@GetMapping("/booksListGrid")
	public String getBooksListGrid() {
		return "booksListGrid";
	}
	

	@GetMapping("/personasListAngular")
	public String getUsersList() {
		
		return "personasListAngular";
	}	

	@GetMapping("/LobsListAngular")
	public String getLobsListAngular() {
		
		return "LobsListAngular";
	}	
	
	
	@GetMapping("/PdfsListAngular")
	public String getPdfsListAngular() {
		
		return "PdfsListAngular";
	}	
	
	
	@GetMapping("/empleadosListPDF")
	public String getEmpleadosList() {
		
		return "empleadosListPDF";
	}
	
	@GetMapping("/empleadosOrderByProvincia")
	public String getempleadosOrderByProvincia() {
		
		return "empleadosOrderByProvincia";
	}	
	
	
	@GetMapping("/personasListGrid")
	public String getUsersGrid() {
		
		return "personasListGrid";
	}		

	@GetMapping("/provsList")
	public String getProvsList() {
		
		return "provsList";
	}	

	@GetMapping("/provsComboList")
	public String getProvsComboList() {
		
		return "provsComboList";
	}	
	
	@GetMapping("/book-grid-app")
	public String getbookgrid() {
		
		return "book-grid-app.js";
	}

	
	@GetMapping("/itemsTreeList")
	public String getItemsTreeList() {
		return "itemsTreeList";
	}

	@GetMapping("/itemsListPDF")
	public String getItemsPDFList() {
		return "itemsListPDF";
	}
		
	@GetMapping("/booksListPDF")
	public String getbooksListPDF() {
		return "booksListPDF";
	}
	
	@GetMapping("/booksListPDF2")
	public String getbooksListPDF2() {
		return "booksListPDF2";
	}
	
	@GetMapping("/booksListPDF3")
	public String getbooksListPDF3() {
		return "booksListPDF3";
	}
	
	@GetMapping("/empleadosListTable")
	//@RequestMapping(value = "/itemTreeList", method = RequestMethod.GET)
	public ModelAndView getempleadosListTable(Model model) {
		List<Empleado> empsList = empleadoService.findAll();
		return new ModelAndView("empleadosListTable","empsList", empsList);
		
	}	
	
	
	@GetMapping("/itemsTreeList4")
	//@RequestMapping(value = "/itemTreeList", method = RequestMethod.GET)
	public ModelAndView getAllItemsTreeList4(Model model) {
		List<Item> items = itemService.findAllByOrderById();
		return new ModelAndView("itemsTreeList4","items", items);
		
	}		

	@GetMapping("/itemTreeList")
	//@RequestMapping(value = "/itemTreeList", method = RequestMethod.GET)
	public ModelAndView getAllItemsTreeList2(Model model) {
		List<Item> items = itemService.findAllByOrderById();
		return new ModelAndView("itemTreeList2","items", items);
		
	}	
	
	@GetMapping("/itemTableList")
	//@RequestMapping(value = "/itemTreeList", method = RequestMethod.GET)
	public String getAllItemsTableList(Model model) {
		//List<Item> itemList = itemSesrvice.findAllByOrderById();
		//Map<String, Object> map = new HashMap<String, Object>();
		//map.put("itemList", itemList);
		//return new ModelAndView("itemTreeList", "map", map);
		model.addAttribute("items", itemService.findAllByOrderById());
		return ("itemTableList");
	}

	@GetMapping("/itemsListPDF2")
	//@RequestMapping(value = "/itemTreeList", method = RequestMethod.GET)
	public ModelAndView getAllItemsPDF(Model model) {
		List<Item> items = itemService.findAllByOrderById();
		return new ModelAndView("itemsListPDF2","items", items);
		
	}		

	
}
