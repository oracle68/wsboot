package com.wsboot.repository;


import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.wsboot.entity.City;


@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    

	
	public List <City> findAllByOrderById();
	public List <City> findAllByOrderByNom();	
	
	public List <String> findAllByNom();
	
}
