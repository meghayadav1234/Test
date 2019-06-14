package com.yash.java;

public class MyRuntimeException extends RuntimeException {
	
	
	 public MyRuntimeException(String message) 
	    { 
	        super(message); 
	        System.out.println(message);
	    }

	

}
