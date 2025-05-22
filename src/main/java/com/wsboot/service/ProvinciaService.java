package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Provincia;
import com.wsboot.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

    //@Autowired
    //ProvinciaRepository pDao;

    private final ProvinciaRepository pDao;

    @Autowired
    public ProvinciaService(ProvinciaRepository pDao) {
        this.pDao = pDao;
    }

   /* public String callFuncInsertProvincia(String provname) {
        return  pDao.callFuncInsertProvincia(provname);
    }  
*/
    public void callInsertProvincia(String nuevaProv) {
        pDao.callInsertProvincia(nuevaProv);
   }  
    
         
    
    public List<Provincia> findAll() {
        return this.pDao.findAll();
    }


    public Page<Provincia> paginas(Pageable pageable){
        return pDao.findAll(pageable);
    }
    
    public Page<Provincia> findAll(int offset, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(sortBy));
        return pDao.findAll(pageable);
    }	    
}
