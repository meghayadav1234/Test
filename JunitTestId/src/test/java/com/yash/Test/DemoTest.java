package com.yash.Test;

import java.util.Optional;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

public class DemoTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/*@Rule
	public Timeout globalTimeout = Timeout.seconds(2);
	*/
	@Ignore
	@Test
	public void test1() {
		System.out.println("In Test 1");
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Name not  null");
		new AdditionTest().checkMessage("A");
	}
	
	@Test(timeout=100)
	public void test2() {
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	
	@BeforeClass
	public static void beforeClass(){
		System.out.println("Before Class");
	}
	@Ignore
	@Test
	public void test2() {
		System.out.println("In Test 2");
	}
	
	@AfterClass
	public static void afterClass(){
		System.out.println("After Class");
	}
	
	@Before
	public void before(){
		System.out.println("Before Test");
	}
	
	@After
	public void after(){
		System.out.println("After Test");
	}*/

}
//@rule
//ExpectedException, timeout,temporaryFolder