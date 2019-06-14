package com.yash;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class CalculateAdditionTest {

	@Test
	public void shouldReturnZeroForEmptyInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="";
		String delimiter =null;
		Integer expectedSum = 0;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);

	}

	@Test
	public void shouldReturnAdditionForOneLengthInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="1";
		String delimiter =null;
		Integer expectedSum = 1;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test
	public void shouldReturnAdditionForGreaterThanOneLengthInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="1,2";
		String delimiter =",";
		Integer expectedSum = 3;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test
	public void shouldReturnAdditionForMoreThanTwoLengthInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="1,2,3,4";
		String delimiter =",";
		Integer expectedSum = 10;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test
	public void shouldReturnAdditionWhenNewLinesBetweenInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="1\n2,3";
		String delimiter =",";
		Integer expectedSum = 6;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test
	public void shouldReturnAdditionWhenNewLineAndCommaBetweenInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="1,\n2,3";
		String delimiter =",";
		Integer expectedSum = 6;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test
	public void shouldReturnAdditionWhenDifferentDelimitersBetweenInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="//;\n1;23;2;344";
		String delimiter =";";
		Integer expectedSum = 370;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		assertEquals(expectedSum,actual);
	}

	@Test(expected = MyRuntimeException.class)
	public void shouldThrowExceptionWhenInputStringContainsNegativeValue(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="//;\n1;23;-2;344;-3";
		String delimiter =";";
		calculator.calculateAdditionOfNumbers(input,delimiter);
	}
	
	@Test
	public void shouldReturnAdditionWhichIgonorNumberGreaterThanThousandInInputString(){
		CalculateAddition calculator = new CalculateAddition();
		String input ="//;\n1;23;2;344;1001";
		String delimiter =";";
		Integer expectedSum = 370;
		Integer actual = calculator.calculateAdditionOfNumbers(input,delimiter);
		System.out.println(actual);
		assertEquals(expectedSum,actual);
	}
}
