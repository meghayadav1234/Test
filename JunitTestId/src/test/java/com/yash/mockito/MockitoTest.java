package com.yash.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.yash.java.Addition;

public class MockitoTest {

	Addition addition;
	@Ignore
	@Test
	public void test(){
		addition = Mockito.mock(Addition.class);

	int num1 = 11;
	int num2 = 12;
	int expected = 24;

	when(addition.sum(num1, num2)).thenReturn(expected);
	
	int actual = addition.add(num1, num2);

	assertEquals(expected, actual);
	}
	
	@Mock
	HashMap<String, Integer> mockHashMap;
	 
	@Test
	public void saveTest()
	{
	    mockHashMap.put("A", 1);
	     
	    Mockito.verify(mockHashMap, times(1)).put("A", 1);
	    Mockito.verify(mockHashMap, times(0)).get("A");
	 
	    assertEquals(0, mockHashMap.size());
	}
}
