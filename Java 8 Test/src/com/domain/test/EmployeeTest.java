package com.domain.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee employee1 = new Employee(
				"Yash",
				20,
				new Address("1234"),
				Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

		Employee employee2 = new Employee(
				"Ram",
				20,
				new Address("1235"),
				Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

		Employee employee3 = new Employee(
				"Sita",
				20,
				new Address("1236"),
				Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

		List<Employee> employees = Arrays.asList(employee1, employee2, employee3);

		// Get employee with exact match name "Yash", if not found print "Not found".
		Optional<String> s = employees.stream().map(x->x.getName()).filter(employeeName -> employeeName.equals("Yash")).findAny();
		System.out.println(s.orElseGet(() ->  "NOT Found"));
		System.out.println("Address Match------------");
		employees.stream().map(x-> x).filter(add -> add.getAddress().getZipcode().equals("1234")).forEach(x->System.out.println(x));
		System.out.println("Number Match------------");
		// employees.stream().flatMap(x->x.getMobileNumbers().stream().filter(mobNo ->mobNo.getNumber().equals("3333"))).forEach(x-> System.out.println(x));

		// employees.stream().map(x-> x.getMobileNumbers()).collect(Collectors.toList()).forEach(x->System.out.println(x));
		employees.stream().filter(x->x.getMobileNumbers().stream().anyMatch(mob->mob.getNumber().equals("3333"))).forEach(System.out::println);;

		System.out.println("Emp List------------");
		List<String> empList = employees.stream().map(x-> x.getName()).collect(Collectors.toList());
		System.out.println(empList);

		List<String> empUpperCaseList = employees.stream().map(x-> x.getName().toUpperCase()).collect(Collectors.toList());
		System.out.println(empUpperCaseList);
		Collections.sort(empUpperCaseList);
		System.out.println(empUpperCaseList);

		Comparator<Employee> comparator = Comparator.comparing(Employee::getName);
		Collections.sort(employees, comparator);
		System.out.println(employees);
		System.out.println(empList.stream().collect(Collectors.joining("||")));
		// Get employee with matching address "1235"
		// Get all employee having mobile numbers 3333.
		// Convert List<Employee> to List<String> of employee nam
		// Collect all the names of employees in a string separated by ||
		// Change the case of List<String>
		// Sort List<String>
		// sort List<Employee> based on name
		// 


	}
}
