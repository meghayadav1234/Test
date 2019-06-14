package com.domain.methodReference;

public class MethodReference {
	public MethodReference(){
		System.out.println("In Constructor");
	}

	public static void main(String[] args) {
		//MethodReference methodReference = new MethodReference();
		MyMethodRef my = MethodReference::new;
		my.draw();
	}

	public static void drawElephant(){
		System.out.println("In Elephant");
	}
	
	public void drawTiger(){
		System.out.println("In Tiger");
	}
}
