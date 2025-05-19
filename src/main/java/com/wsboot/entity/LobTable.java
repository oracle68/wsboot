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
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="LOB_TABLE")

public class LobTable {

	//private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(name = "DOC")
	private byte[] DataBlob;

	/**
	* @return the DataBlob
	*/
	public byte[] getDataBlob(){
	    return DataBlob;
	}

	/**
	* @param DataBlob the DataBlob to set
	*/
	public void setDataBlob(byte[] DataBlob) {
	    this.DataBlob = DataBlob;
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Lob_table [id=" + id + ", autor=" + ", LOB=" + DataBlob
				+ "]";
	}

	
	public LobTable() {
	}
	public LobTable(byte[] DataBlob) {
		super();
		this.DataBlob = DataBlob;

	}
	
	
	
	
}