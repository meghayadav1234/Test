package com.domain.lambdaExpression;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpression {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(13);
		list.add(6);
		list.add(3);
		list.add(20);
		list.add(2);
		list.forEach(x -> System.out.println(x));
		System.out.println("Even List");
		list.forEach(x ->{
			if(x%2 ==0){
				System.out.println(x);
			}
		});
		
		/*MyInterface my = () -> System.out.println("Hi");
		my.sayHi();
		*/
		MyInterface my = () -> {
			return "Hi";
		};

		System.out.println(my.sayHi());
		list.stream().filter(a->a % 2 != 0).forEach(x -> System.out.println(x));
		
		Addition addition = (a,b)-> {
			return a+b;
		};
		Integer total = addition.add(4, 5);
		
		System.out.println(addition.add(2, 3));
		my.toString();
		my.sayHello();
		MyInterface.sayWelcome();
		System.out.println(total);
	}

		
}
