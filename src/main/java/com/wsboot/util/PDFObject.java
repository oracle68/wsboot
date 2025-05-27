package com.wsboot.util;

import java.util.ArrayList;
import java.util.List;

public class PDFObject {

	private String type;
	 
	private int objectNumber;
 
	private int generation;
 
	private List<String> keys = new ArrayList<>();
 
	private String stream;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getObjectNumber() {
		return objectNumber;
	}

	public void setObjectNumber(int objectNumber) {
		this.objectNumber = objectNumber;
	}

	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	public List<String> getKeys() {
		return keys;
	}

	public void setKeys(List<String> keys) {
		this.keys = keys;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}
	
	public PDFObject(int objectNumber, int generation, String type) {
		this.type = type;
		this.objectNumber = objectNumber;
		this.generation = generation;
	}
 
	public PDFObject(int objectNumber, int generation) {
		this.objectNumber = objectNumber;
		this.generation = generation;
	}
 
	public PDFObject(String type) {
		this.type = type;
 
	}	

	public PDFObject(String key, PDFObject obj) {
		addObjectKey(key, obj);
	}
	
	
	public void addKey(String key, String value) {
		keys.add("/" + key + " " + value);
	}
	
	public void addObjectKey(String key, PDFObject value) {
		keys.add("/" + key + "\n" + value.buildObject().toString());
	}
	
	public void addObjectReferenceKey(String key, PDFObject value) {
		keys.add("/" + key + " " + value.getObjectReference());
	}
 
	public void addObjectReferenceArrayKey(String key, PDFObject... values) {
		String finalVal = "/" + key + " [";
		for (PDFObject obj : values) {
			finalVal = finalVal + obj.getObjectReference();
		}
		finalVal = finalVal + "]";
		keys.add(finalVal);
	}	
	
	public String getObjectReference() {
		return objectNumber + " " + generation + " R";
	}
	
	public void addTextStream(String font, int fontSize, int xPos, int yPos, String text) {
		this.stream = "\nstream \n BT \n  /" + font + " " + fontSize + " Tf \n " + xPos + " " + yPos + " Td\n (" + text
				+ ") Tj\nET\nendstream\n";
 
	}
	
	public StringBuilder build() {
		StringBuilder pdfObject = new StringBuilder();
		pdfObject.append(objectNumber).append(" ").append(generation).append(" obj\n  ").append(buildObject())
				.append("\nendobj\n\n");
 
		return pdfObject;
	}
 
	public StringBuilder buildObject() {
		StringBuilder pdfObject = new StringBuilder();
		pdfObject.append("<< ");
		if (type != null) {
			pdfObject.append("/Type /").append(type).append("\n");
		}
		for (String key : keys) {
			pdfObject.append("     ").append(key).append("\n");
		}
		pdfObject.append("  >>");
 
		if (stream != null) {
			pdfObject.append(stream);
		}
 
		return pdfObject;
	}	
	
}
