package com.yash.mockitotutorial.voidmethod;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

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
	public void shouldReturnNothingForAuthenticateUsernameAndPassword() throws NotAuthenticatedException{
		
		String username = "test";
		String password = "test";
		
		doNothing().when(authenticatorInterface).authenticateUser(username, password);
		
		authenticatorApplication.authenticate(username, password);
		
		verify(authenticatorInterface).authenticateUser(username, password);
	}

	@Test(expected = NotAuthenticatedException.class)
	public void shouldThrowExceptionForAuthenticateUsernameAndPassword() throws NotAuthenticatedException{
		
		String username = "test";
		String password = "test";
		
		doThrow(NotAuthenticatedException.class).when(authenticatorInterface).authenticateUser(username, password);
		
		authenticatorApplication.authenticate(username, password);
		
		verify(authenticatorInterface).authenticateUser(username, password);
	}


}
