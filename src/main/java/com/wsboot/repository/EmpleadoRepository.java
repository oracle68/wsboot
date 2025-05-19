package com.wsboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsboot.entity.Empleado;
import org.springframework.data.jpa.repository.Query;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>
{

	public List<Empleado> findAll();
	
	@Query("select e from com.wsboot.entity.Empleado e order by provincia")
	public List<Empleado> empOrderByProvincia();		
	
}
