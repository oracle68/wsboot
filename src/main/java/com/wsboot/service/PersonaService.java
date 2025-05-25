package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Persona;
import com.wsboot.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaDao;

    public List<Persona> findAll() {
        return this.personaDao.findAll();
    }
    
    public void Add(Persona p) {
        personaDao.save(p);
    }    

    
    public void Update(Persona p) {
        personaDao.save(p);
    }       

   // public void Merge(Persona p) {
   //     personaDao.merge(p);
   // }       
    
    
    
    public Page<Persona> paginas(Pageable pageable){
        return personaDao.findAll(pageable);
    }  
    
    public Page<Persona> findAll(int offset, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(sortBy));
        return personaDao.findAll(pageable);
    }	    
}
