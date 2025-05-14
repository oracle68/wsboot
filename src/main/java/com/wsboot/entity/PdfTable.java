package com.wsboot.entity;

//import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="PDF_TABLE")

public class PdfTable {

	//private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Lob
	@Column(name = "PDFDOC")
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

	
	public PdfTable() {
	}
	public PdfTable(byte[] DataBlob) {
		super();
		this.DataBlob = DataBlob;

	}
	
	
	
	
}