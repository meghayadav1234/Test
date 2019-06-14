package com.yash.mockitotutorial.voidmethod;

public class NotAuthenticatedException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAuthenticatedException() {
        super("Could not authenticate!");
    }
}
