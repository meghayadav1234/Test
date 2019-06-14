package com.domain.lambdaExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeDetails {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"A"));
		list.add(new Employee(3,"C"));
		list.add(new Employee(2,"C"));
		list.add(new Employee(4,"B"));
		list.add(new Employee(5,"E"));
		
		/*Comparator<Employee>  comparator  = (p1,p2)->{  
		      return p1.getEmpName().compareTo(p2.getEmpName());
		      };*/
		
		Comparator<Employee> comparator = Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getEmpId);
		Collections.sort(list,comparator);  
		list.forEach(x ->System.out.println("Id : "+x.getEmpId() + " Name : "+x.getEmpName()));
	}

}
