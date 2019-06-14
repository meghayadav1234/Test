package com.yash.mockitotutorial.basecode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class AuthenticatorApplicationTest {

	@InjectMocks
	private AuthenticatorApplication authenticatorApplication;

	@Mock
	private AuthenticatorInterface authenticatorInterface;

	@Test
	public void shouldReturnFalseForNotAuthenticatedUsernameAndPassword() throws EmptyCredentialsException{
		
		String username = "test";
		String password = "test";
		
		when(authenticatorInterface.authenticateUser(username, password)).thenReturn(false);
		
		Boolean actualValue = authenticatorApplication.authenticate(username, password);
		assertFalse(actualValue);
	}

	@Test(expected = EmptyCredentialsException.class)
	public void shouldThrowExceptionForEmptyUsernameAndPassword() throws EmptyCredentialsException{
		
		String username = " ";
		String password = " ";
		
		when(authenticatorInterface.authenticateUser(username, password)).thenThrow(EmptyCredentialsException.class);  
		
		authenticatorApplication.authenticate(username, password);
	}

	@Test
	public void shouldReturnTrueForAuthenticatedUsernameAndPassword() throws EmptyCredentialsException{
		
		String username = "test";
		String password = "test";
		
		when(authenticatorInterface.authenticateUser(username, password)).thenReturn(true);
		
		Boolean actualValue = authenticatorApplication.authenticate(username, password);
		assertTrue(actualValue);
	}

}
