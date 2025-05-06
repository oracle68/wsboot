package com.wsboot.service;

import java.util.List;

import org.hibernate.query.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Example;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.wsboot.entity.Item;
import com.wsboot.repository.ItemRepository;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemDao;
	
    
    
   public List<Item> findAll() {
        return this.itemDao.findAll();
        
        //List<Item> iemList = itemDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

   public List<Item> findAllByOrderById() {
       return this.itemDao.findAllByOrderById();
       
       //List<Item> iemList = itemDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
   }   
 
 /*   Sort sortBy = Sort.by(new Sort.Order(Sort.Direction.ASC, "name").ignoreCase());
 

    @SuppressWarnings("unchecked")
	public List<Item> findAllByOrderByIdAsc() {
        return this.itemDao.findAll(sortByIdAsc());
        
    }   
    

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }  
  */      
    
}
