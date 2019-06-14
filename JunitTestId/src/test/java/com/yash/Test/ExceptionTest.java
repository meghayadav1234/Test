package com.yash.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ExceptionTest {
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test1() {
		System.out.println("In Test 1");
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Name not  null");
		new AdditionTest().checkMessage(null);
	}
	
	@Ignore
	@Test
	public void test2() throws Exception {
		thrown.expect(ArithmeticException.class);
		thrown.expectMessage("Divide by Zero.");
		AdditionTest additionTest = new AdditionTest();
		additionTest.division(1,0);
	}
	
}
