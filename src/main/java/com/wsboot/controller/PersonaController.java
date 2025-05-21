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
import com.wsboot.entity.Persona;
import com.wsboot.repository.PersonaRepository;
import com.wsboot.service.PersonaService;

@EnableWebMvc
@RestController
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

    
    @Autowired
    PersonaService personaService;
 
	@GetMapping("/personasPagList")
	public String personasPagList(Model model,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
     

		try {
			System.out.println("entra 1");
			
			Page<Persona> personasList = personaService.findAll(page, size, sortBy);
			System.out.println("size "+personasList.getSize());
			model.addAttribute("personasList", personasList); 
			//for (i=0)
			System.out.println("entra " + personasList.toString());
		 } catch (Exception e) {
		    model.addAttribute("errorMessage", "Ocurrió un error al obtener las publicaciones.");
		 }		
				
		        System.out.println("return");
				return "personasPagList";
		}	
    

	@GetMapping("/personasPagsList")
	public ModelAndView getempleadosListTable(Model model) {
		List<Persona> pList = personaService.findAll();
		return new ModelAndView("personasPagsList","pList", pList);
		
	}	
	
}
