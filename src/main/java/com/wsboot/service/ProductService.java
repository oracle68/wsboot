package com.wsboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Product;
import com.wsboot.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository pDao;

    public List<Product> findAll() {
        return this.pDao.findAll();
    }

    public List<Product> findAllOrderById() {
        return this.pDao.findAllOrderById();
    }
    
    public Page<Product> paginas(Pageable pageable){
        return pDao.findAll(pageable);
    }
    
    public Page<Product> findAll(int offset, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(offset, pageSize, Sort.by(sortBy));
        return pDao.findAll(pageable);
    }	    
}
