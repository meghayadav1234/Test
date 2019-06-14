package com.yash;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {

	@Test
	public void shouldReturnFizzWhenInputNumberDivisibleByThree(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		Integer inputNumber = 6;
		String expectedOutput = "Fizz";
		String outputString = fizzBuzz.displayFizzBuzz(inputNumber);
		assertEquals(expectedOutput, outputString);
	}
	
	@Test
	public void shouldReturnBuzzWhenInputNumberDivisibleByFive(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		Integer inputNumber = 20;
		String expectedOutput = "Buzz";
		String outputString = fizzBuzz.displayFizzBuzz(inputNumber);
		assertEquals(expectedOutput, outputString);
	}
	@Test
	public void shouldReturnFizzBuzzWhenInputNumberDivisibleByBothFiveAndThree(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		Integer inputNumber = 15;
		String expectedOutput = "FizzBuzz";
		String outputString = fizzBuzz.displayFizzBuzz(inputNumber);
		assertEquals(expectedOutput, outputString);
	}
	
	@Test
	public void shouldReturnOtherwiseWhenInputNumberNotDivisibleByBothFiveAndThree(){
		FizzBuzz fizzBuzz = new FizzBuzz();
		Integer inputNumber = 7;
		String expectedOutput = "otherwise";
		String outputString = fizzBuzz.displayFizzBuzz(inputNumber);
		assertEquals(expectedOutput, outputString);
	}
}
