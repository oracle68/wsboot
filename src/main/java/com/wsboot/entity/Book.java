package com.wsboot.entity;

//import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="Book")

public class Book {

	@Override
	public String toString() {
		return "Book [id=" + id + ", autor=" + autor + ", titulo=" + titulo + ", price=" + price + ", fecha=" + fecha
				+ "]";
	}
	//private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="autor")
	private String autor;
	@Column(name="titulo")
	private String titulo;
	@Column(name="precio")
	private BigDecimal price;
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fecha;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String f = sdf.format(fecha);
		this.fecha = new SimpleDateFormat("dd/MM/yyyy").parse(f);
	}
	public Book() {
	}
	public Book(String autor, String titulo, BigDecimal price, Date fecha) {
		super();
		this.autor = autor;
		this.titulo = titulo;
		this.price = price;
		this.fecha = fecha;
	}
	
	
	
	
}