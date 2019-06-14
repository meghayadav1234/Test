package com.yash.Test;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

public class AssertionTest {

	@Test
	public void test() {
		String s1="junit";
		String s2="Junit";
		String s3 ="Test";
		String s4 ="Test";		
		String s5="ABC";
		int no1 =1;
		int no2 =2;
		
		int[] array1={1,2,3};
		int[] array2={1,2,3};
		
		assertNotEquals(s1, s2);
		assertEquals(s3, s4);		
		assertArrayEquals(array1,array2);
		assertThat("ABC",CoreMatchers.is(s5));
		assertThat("test", anyOf(is("test2"), containsString("tet")));

	}

}
