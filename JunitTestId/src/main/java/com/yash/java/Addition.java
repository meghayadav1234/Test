package com.yash.java;

public class Addition {

	public static void main(String[] args) {
		
	}

	public int sum(int var1, int var2) {
		System.out.println("Adding values: " + var1 + " + " + var2);
		return var1 + var2;
		}
	
	public int add(int a, int b){
		Addition addition = new Addition();
		return addition.sum(a, b);
	}
}
