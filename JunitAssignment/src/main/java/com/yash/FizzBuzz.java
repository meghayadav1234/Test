package com.yash;

public class FizzBuzz {
	
	public String displayFizzBuzz(Integer inputNumber){
		String outputString =null;
		if(inputNumber % 3 == 0 && inputNumber % 5 == 0){
			outputString = "FizzBuzz";
		}else if(inputNumber % 3 == 0 ){
			outputString = "Fizz";
		}else if(inputNumber % 5 == 0){
			outputString = "Buzz";
		}else{
			outputString = "otherwise";
		}
		return outputString;
	}

}
