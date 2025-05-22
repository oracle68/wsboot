package com.wsboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.ParameterMode;
import javax.persistence.Table;

@Entity
@Table(name="Provincia")
@NamedStoredProcedureQuery(name = "Provincia.INSERT_PROVINCIA", procedureName = "INSERT_PROVINCIA", 
 parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "provname", type = String.class)
})

/*@NamedNativeQuery(
    name = "Provincia.INSERT_PROVINCIA_FUN",
    //query = "{ ? = call insert_provincia_func(?)}",
    		query = "SELECT INSERT_PROVINCIA_FUN(:PROVNAME) FROM DUAL}",
    //callable = true,
    resultClass = String.class
)
*/

public class Provincia implements Serializable{


	private static final long serialVersionUID = 1L;


	@Override
	public String toString() {
		return "Provincia [id=" + id + ", nom=" + nom + "]";
	}
	//private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	public Provincia() {
	}

	public Provincia(Long id,String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
	}
	
	
	
	
}