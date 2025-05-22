package com.wsboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

import javax.persistence.Column;

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
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")	
	@Column(name = "FECHA", nullable = true, length = 10)		
	private Date fecha;	

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
	

	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Empleado()
	{
	}

	public Empleado(Integer id,String name,String gender,String adress,String city,String provincia)
	{
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.adress = adress;
		this.city = city;
		this.provincia = provincia;
		
	}
	
	@Override
	public String toString() {
		return "Emp [ provincia=" + provincia + " ,  id=" + id + ", name=" + name + ", gender=" + gender + ", adress=" + adress +
				", city=" + city + ", fecha=" + fecha 
				+ "]";
	}

}

