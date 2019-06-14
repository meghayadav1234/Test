package com.java.streamBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.domain.lambdaExpression.Employee;

public class StreamBuilder {

	public static void main(String[] args) {
		Stream.Builder<String> streamBuilder =  Stream.builder();
		
		Stream<String> stream =streamBuilder.add("A").add("B").add("C").build();
		stream.forEach(System.out::println);
		
		Stream<Integer> stream1  = Stream.of(1,2,3,4,7,8,9,10,23);
		Stream<Integer> stream2  = Stream.of(5,6,11,12,13,14,15);
		Stream<Integer> stream3 =Stream.concat(stream1, stream2);
		//stream3.forEach(System.out::println);
		
		Stream<Integer> stream4 = stream3.distinct();
		stream4.forEach(System.out::print);
	}

}
