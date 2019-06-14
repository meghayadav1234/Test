package com.yash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CalculateAddition {

	private final static Logger logger = LogManager.getLogger(CalculateAdditionTest.class);

	/*public Integer calculateAdditionOfNumbers(String inputNumberString,String inputDelimiter){

		String delimiter =inputDelimiter ;
		Integer addition = 0;
		Boolean isNegative = false;
		List<Integer> negativeNoList = new ArrayList<>();

		if(inputDelimiter != null){
			delimiter = inputDelimiter.concat("|\\n");
		}else{
			delimiter = "\n";
		}
		String newStringWithoutSlash = null;

		if(inputNumberString.equals(" ")){
			return 0;
		}else{
			newStringWithoutSlash = inputNumberString;
			if(inputNumberString.startsWith("//")){
				newStringWithoutSlash = inputNumberString.substring(2);
			}
			String[] stringArray = newStringWithoutSlash.split(delimiter);
			for(int i =0; i < stringArray.length; i++){
				//System.out.println(stringArray[i]);
				if(!stringArray[i].isEmpty()){
					Integer number = Integer.valueOf(stringArray[i]); 
					if(number < 0){
						isNegative = true;
						negativeNoList.add(number);
					}else if(number <= 1000){
						addition += number ;	
					}
				}
			}
		}
		if(isNegative){
			System.out.println(negativeNoList);
			logger.error("Negatives not allowed"+negativeNoList);
			throw new MyRuntimeException("Negatives not allowed"+negativeNoList);
		}
		logger.info("Addition : "+addition);
		return addition;
	}*/


	public Integer calculateAdditionOfNumbers(String inputNumberString,String inputDelimiter){
		String delimiter ="\n" ;
		Integer addition = 0;
		List<Integer> negativeNoList = new ArrayList<>();

		Optional<String> optionalDelimiter = Optional.ofNullable(inputDelimiter);
		if(optionalDelimiter.isPresent()){
			delimiter = inputDelimiter.concat("|\\n");
		}
		if(inputNumberString.equals("")){
			return 0;
		}else{
			String newStringWithoutSlash = inputNumberString;
			if(inputNumberString.startsWith("//")){
				newStringWithoutSlash = inputNumberString.substring(2);
			}
			String[] stringArray = newStringWithoutSlash.trim().split(delimiter);
			negativeNoList = Arrays.asList(stringArray).stream().filter(x->!x.isEmpty()).map(x->Integer.valueOf(x)).filter(x -> x < 0).collect(Collectors.toList());
			addition = Arrays.asList(stringArray).stream().filter(x->!x.isEmpty()).map(x->Integer.valueOf(x)).filter(numberToAdd ->( numberToAdd > 0 && numberToAdd <= 1000)).collect(Collectors.summingInt(n->n));
		}
		if(!negativeNoList.isEmpty()){
			logger.error("Negatives not allowed"+negativeNoList);
			throw new MyRuntimeException("Negatives not allowed"+negativeNoList);
		}
		logger.info("Addition : "+addition);
		return addition;
	}
}
