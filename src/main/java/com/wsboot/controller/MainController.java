package com.wsboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import com.wsboot.entity.Item;
import com.wsboot.service.ItemService;





@CrossOrigin(origins = "http://localhost:9999")
@Controller
public class MainController {

    @Autowired
    ItemService itemService;
    
	@GetMapping("/index")
	public ModelAndView getIndex() {
		
		return new ModelAndView("index");
	}

	
	@GetMapping("/menu")
	public ModelAndView getMenu() {
		
		return new ModelAndView("menu");
	}
	
	
	@GetMapping("/itemsListAngular")
	public String getItemsListAngular() {
		return "itemsListAngular";
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

	@GetMapping("/personasListGrid")
	public String getUsersGrid() {
		
		return "personasListGrid";
	}		

	@GetMapping("/book-grid-app")
	public String getbookgrid() {
		
		return "book-grid-app.js";
	}

	
	@GetMapping("/itemsTreeList")
	public String getItemsTreeList() {
		return "itemsTreeList";
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
	

}
