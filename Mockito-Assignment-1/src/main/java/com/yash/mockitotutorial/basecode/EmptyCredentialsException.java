package com.yash.mockitotutorial.basecode;

public class EmptyCredentialsException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyCredentialsException() {
        super("Empty credentials!");
    }
}
