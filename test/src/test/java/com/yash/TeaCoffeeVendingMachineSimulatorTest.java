package com.yash;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class TeaCoffeeVendingMachineSimulatorTest {

	@InjectMocks
	private TeaCoffeeVendingMachineMenu teaCoffeeVendingMachineMenu;
	
	@Mock
	private ScannerTeaCoffeeMachine scannerTeaCoffeeMachine;

	/*@Test
	public void shouldMakeCoffeeForVendingMachine() throws Exception{
		String input = "1 1 9";
		String[] args = new String[]{};
		InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine();
	}*/
	
	@Test
	public void shouldMakeCoffeeForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(1);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	@Test
	public void shouldMakeTeaForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(2);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	@Test
	public void shouldMakeBlackCoffeeForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(3);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	@Test
	public void shouldMakeBlackTeaForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(4);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	@Test
	public void shouldCheckContainerStatusForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(7);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	@Test
	public void shouldResetContainerForVendingMachine(){
	    when(scannerTeaCoffeeMachine.nextInt()).thenReturn(8);
        teaCoffeeVendingMachineMenu.DisplayMenuForTeaCoffeeVendingMachine(false);
	}
	
	
}
