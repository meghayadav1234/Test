package com.domain.lambdaExpression;
@FunctionalInterface
public interface MyInterface {

	//public void sayHi();
		
	public String sayHi();
	
	public String toString();
	
	public default void sayHello(){
		System.out.println("Hello My Interface");
	}
	
	public static void sayWelcome(){
		System.out.println("Welcome");
	}
}
