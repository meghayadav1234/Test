package com.yash.test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.yash.java.Employee;
import com.yash.java.HomeDaoImpl;
import com.yash.java.HomeServiceImpl;


@RunWith(MockitoJUnitRunner.Silent.class) 
public class HomeControllerTest {

	@InjectMocks
	private HomeServiceImpl homeServiceImpl;

	@Mock
	private HomeDaoImpl homeDaoImpl;

	@Ignore
	@Test
	public void Addition() {
		int num1 = 11;
		int num2 = 12;
		int expected = 24;
		when(homeDaoImpl.sum(num1, num2)).thenReturn(expected);
		//System.out.println(homeServiceImpl.additionOfNumbers(num1, num2));
		assertEquals(expected,homeDaoImpl.sum(num1, num2));
		verify(homeDaoImpl).sum(num1, num2);
	}
	
	@Test
	public void getEmployee(){
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(new Employee(1, "A")); 
		employees.add(new Employee(2, "B")); 
		
		when(homeDaoImpl.getEmployees()).thenReturn(employees);
		assertEquals(employees,homeServiceImpl.getEmployees());
		 //verify(homeDaoImpl, times(3)).getEmployees();
		employees =new ArrayList<Employee>();
		List myMockedList = mock(ArrayList.class);  
        
        when(myMockedList.get(1)).thenThrow(new NullPointerException());  
        doThrow(new RuntimeException()).when(myMockedList).clear();  
  
        System.out.println(myMockedList.get(1));  
        myMockedList.clear();  

	}
}
