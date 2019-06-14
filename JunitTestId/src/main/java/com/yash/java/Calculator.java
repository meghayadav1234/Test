package com.yash.java;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.yash.Test.CalculatorTest;


public class Calculator {
	  final static Logger logger = LogManager.getLogger(CalculatorTest.class);
	  
	public Integer calculateSum(String inputNumber){
		Integer addition = 0;
		String inputNumberString = inputNumber + "_";
		if(inputNumber.equals("")){
			return 0;
		}else{
			char[] inputStringCharArray = inputNumberString.toCharArray();
			List<String> list = new ArrayList<>();
			StringBuilder s = new StringBuilder();
			for(int i=0 ;i < inputStringCharArray.length ;i++){
				 String stringNumber= Character.toString(inputStringCharArray[i]);
				if(Character.isDigit(inputStringCharArray[i]) || stringNumber.equals("-")){
					s.append(inputStringCharArray[i]);
				}else{
					if(s.length() > 0)
					list.add(s.toString());
					s=new StringBuilder();
				}
			}
			List<Integer> negativeNoList = new ArrayList<>();
			Boolean isNegative = false;
			for(String stringNumber : list){
				//System.out.println(stringNumber);
				Integer number = Integer.valueOf(stringNumber); 
				if(number < 0){
					isNegative = true;
					negativeNoList.add(number);
				}else if(number <= 1000){
					addition += number ;	
				}
			}
			if(isNegative){
				System.out.println(negativeNoList);
				logger.error("Negatives not allowed"+negativeNoList);
				throw new MyRuntimeException("Negatives not allowed"+negativeNoList);
			}
			logger.info("Addition : "+addition);
			return addition;
		}
	}
	
}
