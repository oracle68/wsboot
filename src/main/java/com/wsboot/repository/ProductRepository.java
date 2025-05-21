package com.wsboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsboot.entity.Product;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long>
{

	public List<Product> findAll();
	
	@Query("select e from com.wsboot.entity.Product e order by id")
	public List<Product> findAllOrderById();		
	
}
