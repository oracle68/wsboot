package com.wsboot.repository;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.wsboot.entity.Provincia;


@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long> {

    

	@Procedure("INSERT_PROVINCIA")
	void callInsertProvincia(String provname);
	
	//@Query("SELECT INSERT_PROVINCIA_FUN(:PROVNAME) FROM DUAL")
	//String callFuncInsertProvincia(String provname);
	
}
