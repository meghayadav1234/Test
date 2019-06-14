package com.domain.stream;

import java.util.Set;

public class EmployeeBooks {

	private String employeeName;
	
	private Set<String> books;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Set<String> getBooks() {
		return books;
	}

	public EmployeeBooks(String employeeName, Set<String> books) {
		super();
		this.employeeName = employeeName;
		this.books = books;
	}

	public void setBooks(Set<String> books) {
		this.books = books;
	}
}
