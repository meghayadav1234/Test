package com.domain.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.domain.lambdaExpression.Employee;

public class PredicateTest {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"A"));
		list.add(new Employee(3,"C"));
		list.add(new Employee(2,"C"));
		list.add(new Employee(4,"B"));
		list.add(new Employee(5,"E"));
		Employee emp = new Employee(6, "G");
		 Predicate<Employee> predicate =  x -> (x.getEmpId() > 2); 
		// System.out.println(predicate.test(new Employee(4,"A")));
		list.forEach(x ->{
			System.out.println(predicate.test(x));
			
		});
		System.out.println("-------");
		System.out.println(list.stream().allMatch(x -> (x.getEmpId() > 2)));
		
		System.out.println(predicate.negate().test(emp));
		Predicate<Employee> predicate2 =  x -> (x.getEmpId() < 2); 
		System.out.println(predicate.or(predicate2).test(emp));
		
		List<Employee> l = list.stream().filter(predicate).collect(Collectors.toList());
		l.forEach(x ->System.out.println(x.getEmpId()+" "+ x.getEmpName()));
		
		
			
	}

}
