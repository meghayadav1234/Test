package com.yash.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository("homeDaoImpl")
public class HomeDaoImpl {

	public static final List<Employee> e = Arrays.asList(new Employee(1, "A"));
	
	public int sum(int var1, int var2) {
		System.out.println("Adding values: " + var1 + " + " + var2);
		return var1 + var2;
	}

	public List<Employee> getEmployees() {
		System.out.println(e);
		return e;
	}
	
	
	
}
