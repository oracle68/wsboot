package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Empleado;
import com.wsboot.repository.EmpleadoRepository;

@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository eDao;

    public List<Empleado> findAll() {
        return this.eDao.findAll();
    }

    public List<Empleado> empOrderByProvincia() {
        return this.eDao.empOrderByProvincia();
    }
    
    public Page<Empleado> paginas(Pageable pageable){
        return eDao.findAll(pageable);
    }    
}
