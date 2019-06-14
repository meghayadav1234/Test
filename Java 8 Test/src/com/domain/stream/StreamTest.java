package com.domain.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("4");
		list.add("3");
		list.add("2");

		Stream<String> stream = list.stream();
	//	Predicate<String> predicate =  x -> (x > 0); 
		//List<Integer> l = list.stream().mapToInt((x) -> x).filter(x ->x >0).collect(Collectors.toList().);
	//display even no from given string list
		
		list.stream().mapToInt(x->Integer.parseInt(x)).filter(x -> x%2 !=0).forEach(x-> System.out.println(x));
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer i = numbers.stream().reduce(5, (x,y)->x+y);
		System.out.println(i);
		System.out.println(numbers.stream().skip(5).reduce(5, (x,y)->x+y));
		
		list.stream().sorted().forEach(x->System.out.println(x));
		System.out.println("--------------------");
		list.stream().limit(3).iterator().forEachRemaining(x-> System.out.println(x));
	}

}
