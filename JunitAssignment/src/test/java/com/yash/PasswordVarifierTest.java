package com.yash;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PasswordVarifierTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void passwordVarifyBySize() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testTest1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyBySizeLessThanGiven()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testT";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNullValue() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = null;
		assertFalse(passwordVarifier.passwordVarify(password));

	}

	@Test
	public void passwordVarifyByOneUpperCaseLetter()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoUpperCaseLetter()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "desttesr1";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByOneLowerCaseLetter()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoLowerCaseLetter()  {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "REEEEEDRDD";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByOneDigit() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesr1";
		assertTrue(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVarifyByNoDigit() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Testtesrsdf";
		assertFalse(passwordVarifier.passwordVarify(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMust(){
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "thT12";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByLessThanThreeConditions() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "Tr";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustGreaterThan8() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testTsdadsad";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustOneUpperCase() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "testsdadsad";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test
	public void passwordVerifyByThreeConditionsMustOneLowerCaseLetterMust() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "TFJHJHSHSJSDs";
		assertTrue(passwordVarifier.passwordVerifyByThreeConditionsMust(password));
	}

	@Test(expected = MyRuntimeException.class)
	public void passwordVerifyByThreeConditionsMustNoAnyLowerCaseLetter() {
		PasswordVarifier passwordVarifier = new PasswordVarifier();
		String password = "FFFFFFFFF";
		passwordVarifier.passwordVerifyByThreeConditionsMust(password);
	}

	@Test(expected = MyRuntimeException.class)
	public void passwordVerifyByThreeConditionsMustNoAnyLowerCaseLetterThenException() {
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
