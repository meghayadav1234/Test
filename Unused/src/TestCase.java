import org.junit.Test;

public class TestCase {
	@Test
	public void shouldCheckMilkContainerUnderflowConditionForMakeDrink(){

		Integer refillContainerChoice = 4; 
		Integer amountToFill = 32 ;
		Integer cupCount = 113;
		String drinkType ="Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,1);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,1);
	}

	@Test
	public void shouldCheckWaterContainerUnderflowConditionForMakeDrink(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 8 ;
		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,1);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,1);
	}

	@Test
	public void shouldCheckContainerUnderflowConditionForMakeDrink(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 14968 ;
		Integer cupCount = 89;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill);
	}
}
