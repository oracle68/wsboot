package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wsboot.entity.City;
import com.wsboot.repository.CityRepository;

@Service
public class CityService {

    @Autowired
    CityRepository pDao;

         
    
    public List<City> findAll() {
        return this.pDao.findAll();
    }

    public List <City> findAllByOrderById()
    {
        return this.pDao.findAllByOrderById();
    }    
    

    public List <City> findAllByOrderByNom()
    {
        return this.pDao.findAllByOrderByNom();
    }    
    

    public List <String> findAllByNom()
    {
        return this.pDao.findAllByNom();
    }  
    
    public Page<City> paginas(Pageable pageable){
        return pDao.findAll(pageable);
    }
    
    public Page<City> findAll(int offset, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(sortBy));
        return pDao.findAll(pageable);
    }	    
}
