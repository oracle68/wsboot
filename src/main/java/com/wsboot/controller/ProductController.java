package com.wsboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wsboot.entity.Empleado;
import com.wsboot.entity.Product;
import com.wsboot.repository.ProductRepository;
import com.wsboot.service.ProductService;

@EnableWebMvc
@RestController
public class ProductController {

    @Autowired
    ProductRepository pRepository;

    
    @Autowired
    ProductService pService;
 
	@GetMapping("/productsPagList")
	public String personasPagList(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
     

		try {
			System.out.println("entra 1");
			
			Page<Product> pList = pService.findAll(page, size, sortBy);
			System.out.println("size "+pList.getSize());
			model.addAttribute("pList", pList); 
			//for (i=0)
			System.out.println("entra " + pList.toString());
		 } catch (Exception e) {
		    model.addAttribute("errorMessage", "Ocurrió un error al obtener las publicaciones.");
		 }		
				
		        System.out.println("return");
				return "productsPagList";
		}	
    
	@GetMapping("/productsList")
	public List <Product> findAllProducts() {
		
		List <Product> productsList = pService.findAll();
		return productsList;
	}	
	
	
	@GetMapping("/productsOrderById")
	public List <Product> productsOrderById() {
		
		List <Product> pList = pService.findAllOrderById();
		return pList;
	}	

	
}
