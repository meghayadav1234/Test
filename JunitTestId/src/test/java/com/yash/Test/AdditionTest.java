package com.yash.Test;


import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;

import com.yash.java.Addition;
public class AdditionTest  {
	/*Addition calculation = new Addition();
	int sum = calculation.sum(2, 5/1);
	int testSum = 7;
	@Test
	public void testSum() {
	System.out.println("@Test sum(): " + sum + " = " + testSum);
	assertEquals(sum, testSum);
	}
	*/
	public void division(int a, int b) throws Exception {
		if(b==0){
			throw new ArithmeticException("Divide by Zero.");
		}else{
			System.out.println(a/b);
		}
	}
	public void checkMessage(String name){
		//String name= "A";
		Optional<String> optional = Optional.ofNullable(name);
		System.out.println(optional.isPresent());
		if(optional.isPresent()){
			System.out.println(name.equalsIgnoreCase("A"));
		}else{
			throw new NullPointerException("Name not  null");
		}
	}
}
