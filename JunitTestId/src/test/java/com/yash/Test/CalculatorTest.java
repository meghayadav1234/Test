package com.yash.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.yash.java.Calculator;
import com.yash.java.MyRuntimeException;

public class CalculatorTest {

	@Test
	public void stringCalculatorReturnZeroForEmptyStringTest(){
		Calculator calculator = new Calculator();
		String input ="";
		Integer expectedSum = 0;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test
	public void stringCalculatorReturnAdditionForOneLengthStringTest(){
		Calculator calculator = new Calculator();
		String input ="1";
		Integer expectedSum = 1;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test
	public void stringCalculatorReturnAdditionForGreaterThanOneLengthStringTest(){
		Calculator calculator = new Calculator();
		String input ="1,2";
		Integer expectedSum = 3;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test
	public void stringCalculatorReturnAdditionForMoreThanTwoLengthStringTest(){
		Calculator calculator = new Calculator();
		String input ="1,2,3,4";
		Integer expectedSum = 10;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	@Test
	public void stringCalculatorReturnAdditionForNewLinesBetweenInputStringTest(){
		Calculator calculator = new Calculator();
		String input ="1\n2,3";
		Integer expectedSum = 6;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test
	public void stringCalculatorReturnAdditionForNewLineAndCommaBetweenInputStringTest(){
		Calculator calculator = new Calculator();
		String input ="1,\n2,3";
		Integer expectedSum = 6;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test
	public void stringCalculatorReturnAdditionForDifferentDelimitersBetweenInputStringTest(){
		Calculator calculator = new Calculator();
		String input ="//;\n1;23;2;344";
		Integer expectedSum = 370;
		Integer actual = calculator.calculateSum(input);
		assertEquals(expectedSum,actual);
	}
	
	@Test(expected = MyRuntimeException.class)
	public void stringCalculatorReturnReturnExceptionWhenInputStringContainsNegativeTest(){
		Calculator calculator = new Calculator();
		String input ="//;\n1;23;-2;344;-3";
		calculator.calculateSum(input);
	}
	
	@Test
	public void stringCalculatorReturnAdditionIgonorNumerGreaterThanThousandTest(){
		Calculator calculator = new Calculator();
		String input ="//;\n1;23;2;344;1001";
		Integer expectedSum = 370;
		Integer actual = calculator.calculateSum(input);
		//System.out.println(actual);
		assertEquals(expectedSum,actual);
	}
}
