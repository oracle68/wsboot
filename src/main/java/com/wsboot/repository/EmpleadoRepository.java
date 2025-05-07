package com.wsboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wsboot.entity.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>
{

	public List<Empleado> findAll();
	
}
