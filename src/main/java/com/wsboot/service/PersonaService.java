package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Persona;
import com.wsboot.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    PersonaRepository userDao;

    public List<Persona> findAll() {
        return this.userDao.findAll();
    }
    
    public Page<Persona> paginas(Pageable pageable){
        return userDao.findAll(pageable);
    }    
}
