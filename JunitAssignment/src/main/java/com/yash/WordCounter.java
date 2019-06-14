package com.yash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {

	public Map<String,Integer> wordCount(String input,String delimiter){
		Map<String, Integer> stringWordCount =new HashMap<String, Integer>();
		if(input != null && delimiter != null){
			String[] inputStringArray = input.split(delimiter);

			for(String s : Arrays.asList(inputStringArray)){
				Integer i = stringWordCount.get(s);
				stringWordCount.put(s,(i==null ?1:i+1));
			}
		}else{
			throw new NullPointerException("Input Not Null.");
		}
		return stringWordCount;
	}
}
