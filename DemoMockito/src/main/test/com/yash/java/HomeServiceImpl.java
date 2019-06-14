package com.yash.java;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("homeServiceImpl")
public class HomeServiceImpl implements IHomeService{

	@Autowired
	private HomeDaoImpl homeDaoImpl;

	public int additionOfNumbers(int var1, int var2) {
		return homeDaoImpl.sum(var1, var2);
	}

	public List<Employee> getEmployees() {
		return homeDaoImpl.getEmployees();
	}
}
