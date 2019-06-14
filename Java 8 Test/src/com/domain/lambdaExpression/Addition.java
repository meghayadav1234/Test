package com.domain.lambdaExpression;
@FunctionalInterface
public interface Addition {

	public Integer add(int a, int b);
	
	public default void sayHello(){
		System.out.println("Hello Addition");
	}
}
