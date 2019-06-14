package com.yash.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.yash.java.MyRuntimeException;
import com.yash.java.PasswordVarifier;

public class PasswordVarifierTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void passwordVarifyBySizeTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testTest1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyBySizeLessThanGivenTest()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testT";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNullValueTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = null;
		assertFalse(passwordVarifier.passwordVarify(password));

	}

	@Test
	public void passwordVarifyByOneUpperCaseLetterTest()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoUpperCaseLetterTest()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "desttesr1";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByOneLowerCaseLetterTest()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoLowerCaseLetterTest()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "REEEEEDRDD";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByOneDigitTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoDigitTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesrsdf";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustTest(){
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "thT12";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	/*@Test
	public void passwordVerifyByLessThanThreeConditionsTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Tr";
		thrown.expect(Exception.class);
		thrown.expectMessage("Atleast 3 conditions must");
		passwordVarifier.passwordVerifyByThreeConditionsMust(password);
	}*/

	@Test
	public void passwordVerifyByThreeConditionsMustGreaterThan8Test() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testTsdadsad";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustOneUpperCaseTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testsdadsad";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustOneLowerCaseLetterMustTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "TFJHJHSHSJSDs";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustNoAnyLowerCaseLetterTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "F";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test(expected = MyRuntimeException.class)
	public void passwordVerifyByThreeConditionsMustNoAnyLowerCaseLetterThenExceptionTest() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "f";
		passwordVarifier.passwordVerifyByThreeConditionsMust(password);
	}

	@Test(expected = MyRuntimeException.class)
	public void passwordVerifyByThreeConditionsMustPasswordNotNull() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = null;
		passwordVarifier.passwordVerifyByThreeConditionsMust(password);
	}
}
