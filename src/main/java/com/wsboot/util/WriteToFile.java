package com.wsboot.util;

	import java.io.FileWriter;   // Import the FileWriter class
	import java.io.IOException;  // Import the IOException class to handle errors

	public class WriteToFile {
	  //public static void main(String[] args) {
		public static void escriuText (String filename,String text) {
	    try {
	      FileWriter myWriter = new FileWriter(filename);
	      myWriter.write(text);
	      myWriter.close();
	      //System.out.println("Successfully wrote to the file.");
	    } catch (IOException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }

		public static void escriuLista (String filename,java.util.List lista) {
		    try {
		      FileWriter myWriter = new FileWriter(filename);
		      for (int i = 0; i < lista.size(); i++) {
		    	  myWriter.write(lista.get(i).toString()+"\n"); //  System.out.println(names.get(i));
		    	}		      
		      
		      myWriter.close();
		      //System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		  }

		
	}
