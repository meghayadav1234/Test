package com.yash;

public class MyRuntimeException extends RuntimeException {
	
	
	 public MyRuntimeException(String message) 
	    { 
	        super(message); 
	        System.out.println(message);
	    }

	

}
