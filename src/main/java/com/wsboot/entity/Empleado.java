package com.wsboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "EMPLEADOS")
public class Empleado  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name = "NAME", nullable = true, length = 50)	
	private String name;
	@Column(name = "GENDER", nullable = true, length = 50)		
	private String gender;
	@Column(name = "ADRESS", nullable = true, length = 50)		
	private String adress;
	@Column(name = "CITY", nullable = true, length = 50)		
	private String city;
	@Column(name = "PROVINCIA", nullable = true, length = 50)		
	private String provincia;	
	


	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}

	public String getProvincia() {
		return provincia;
	}


	public void setProvince(String provincia) {
		this.provincia = provincia;
	}
	

	
	public Empleado()
	{
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}

