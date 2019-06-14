package com.domain.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.domain.lambdaExpression.Employee;

public class EmployeeStream {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1, "A"));
		list.add(new Employee(2, "B"));
		
		List<Employee> list2 = new ArrayList<Employee>();
		list2.add(new Employee(4, "AC"));
		list2.add(new Employee(3, "AD"));
		list2.add(new Employee(5, "BA"));
		
		List<Employee> filterdList = list.stream().filter(String -> String.getEmpName().startsWith("A")).collect(Collectors.toList());
		filterdList.forEach(x -> System.out.println(x.getEmpId()+ " "+x.getEmpName()));
	
		list.stream().map(String -> String.getEmpName()).filter(x -> x.startsWith("A")).forEach(x -> System.out.println(x));
		
		list.stream().map(y -> y).filter(x -> x.getEmpName().startsWith("A")).forEach(x -> System.out.println(x.getEmpId()));
		
		System.out.println("--------------");
		List<List<Employee>> listOfEmpList = new ArrayList<List<Employee>>();
		listOfEmpList.add(list);
		listOfEmpList.add(list2);
		listOfEmpList.forEach(x -> x.forEach(y->System.out.println(y.getEmpId()+" "+y.getEmpName())));
		System.out.println("--------------");
		listOfEmpList.stream().flatMap(x -> x.stream().map(z ->z).filter(y -> y.getEmpName().startsWith("A"))
		).forEach(a -> System.out.println(a.getEmpId()));
		
		System.out.println("--------------");
		List<Employee> empList = listOfEmpList.stream().flatMap(x -> x.stream().map(z ->z).filter(y -> y.getEmpName().startsWith("B"))
		).collect(Collectors.toList());
		empList.forEach(x ->System.out.println(x.getEmpId() + x.getEmpName()));
		System.out.println("--------------");
		List<EmployeeBooks> employeeBooksList = new ArrayList<EmployeeBooks>();
		Set<String> booksA = new HashSet<String>();
		booksA.add("Java");
		booksA.add("C");
		employeeBooksList.add(new EmployeeBooks("A", booksA));
		Set<String> booksB = new HashSet<String>();
		booksB.add("Java");
		booksB.add("C++");
		booksB.add(".Net");
		employeeBooksList.add(new EmployeeBooks("B", booksB));
		
		Set<String> booksC = new HashSet<String>();
		booksC.add("C++");
		booksC.add(".Net");
		employeeBooksList.add(new EmployeeBooks("C", booksC));
		
		employeeBooksList.stream().flatMap(x -> x.getBooks().stream()).distinct().forEach(y->System.out.println(y));
		//System.out.println("--------------Print All Employee and books------");
		//employeeBooksList.stream().map(a ->a.getEmployeeName()).forEach(x->System.out.println(x));
		
		System.out.println("--------------");
		Comparator<Employee> comparator = Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getEmpId);
		list2.stream().sorted(comparator).forEach(x -> System.out.println(x.getEmpId()+x.getEmpName()));
		System.out.println("--------------");
		System.out.println(list2.stream().min(comparator).get().getEmpId());
		
	}

}
