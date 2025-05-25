package com.wsboot.util;

import org.springframework.beans.factory.annotation.Autowired;

import com.wsboot.entity.Empleado;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.SessionFactory;

public class ColumnNames {

	
    @Transactional
	public void columnNames(SessionFactory  SessionFactory, String tabla){
		String clase = ""+tabla+".class";
	String[] columnNames = SessionFactory.getSessionFactory().getClassMetadata(clase).getPropertyNames(); 

	for (int i=0;i<columnNames.length;i++)
	{
		System.out.println(columnNames[i]);	
	}
	}
}
