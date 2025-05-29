package com.wsboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;

@Entity
@Table(name="City")

@NamedQueries({
@NamedQuery(name = "City.findAllByOrderById",
query = "select u from com.wsboot.entity.City u order by id"),
@NamedQuery(name = "City.findAllByOrderByNom",
query = "select u from com.wsboot.entity.City u order by nom")
})

@NamedNativeQuery(name="City.findAllByNom", query="SELECT nom FROM City order by nom")

/*@NamedNativeQuery(
    name = "Provincia.INSERT_PROVINCIA_FUN",
    //query = "{ ? = call insert_provincia_func(?)}",
    		query = "SELECT INSERT_PROVINCIA_FUN(:PROVNAME) FROM DUAL}",
    //callable = true,
    resultClass = String.class
)
*/

public class City implements Serializable{


	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nom=" + nom + "]";
	}
	//private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="idCity")
	private Long id;
	@Column(name="nom")
	private String nom;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNomme(String nom) {
		this.nom = nom;
	}
	public City() {
	}

	public City(Long id,String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
	}
	
	
	
	
}