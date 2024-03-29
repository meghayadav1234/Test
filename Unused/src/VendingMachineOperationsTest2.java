

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class) 
public class VendingMachineOperationsTest2 {

	@InjectMocks
	private VendingMachineOperations vendingMachineOperations;

	@Test
	public void shouldReturnTrueToMakeCoffeeForNumberOfCupAsInput(){
		Integer cupCount = 1;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertTrue(expectedOutput);
	}

	@Test
	public void shouldReturnFalseToMakeTeaForNumberOfCupInput(){
		Integer cupCount = 0;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertFalse(expectedOutput);
	}
	
	@Test
	public void shouldShowMessageAsNoEnoughMaterialForNoOfCupCount(){
		Integer cupCount = 200;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertFalse(expectedOutput);
	}
	
	@Test
	public void shouldShowMessageWhenAmountToFillIsLessThanZeroToRefillContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = -1 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	
	@Test
	public void shouldRefillCoffeeContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillCoffeeContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldRefillTeaContainer(){

		Integer refillContainerChoice = 2; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill, false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillTeaContainer(){

		Integer refillContainerChoice = 2; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill ,false);
	}

	@Test
	public void shouldRefillWaterContainer(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillWaterContainer(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldRefillMilkContainer(){

		Integer refillContainerChoice = 4; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillMilkContainer(){

		Integer refillContainerChoice = 4; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldRefillSugarContainer(){

		Integer refillContainerChoice = 5; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	
	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillSugarContainer(){

		Integer refillContainerChoice = 5; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldCheckSelectedChoiceIsInvalidToRefillContainer(){

		Integer refillContainerChoice = 6; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	
	@Test
	public void shouldCheckTotalSaleForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldCheckContainerStatusForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.checkContainerStatusForVendingMachine();
	}
	
	@Test
	public void shouldResetContainerForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.resetContainerForVendingMachine();
	}
	
	@Test
	public void shouldAddRefillCountInJsonObjToRefillContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
	}
	
	@Test
	public void shouldDisplayRefillCountFromJsonObjInTotalSaleReport(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldCheckNullForRefillCountFromJsonObjInTotalSaleReport(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldAddTotalCupCountInJsonObjInMakeDrink(){

		Integer cupCountOne = 50;
		String drinkTypeOne ="Coffee";
		
		Integer cupCountTwo = 1;
		String drinkTypeTwo ="Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkTypeOne,cupCountOne);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkTypeTwo,cupCountTwo);
	}
	/*
	 
	@Test
	public void shouldReturnTrueToMakeCoffeeForNumberOfCupAsInput(){
		Integer cupCount = 1;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertTrue(expectedOutput);
	}
	@Test
	public void shouldReturnTrueToMakeTeaForNumberOfCupInput(){
		Integer cupCount = 1;
		String drinkType ="Tea";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertTrue(expectedOutput);
	}

	@Test
	public void shouldReturnTrueToMakeBlackTeaForNumberOfCupInput(){
		Integer cupCount = 1;
		String drinkType ="Black Tea";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertTrue(expectedOutput);
	}

	@Test
	public void shouldReturnTrueToMakeBlackCoffeeForNumberOfCupInput(){
		Integer cupCount = 1;
		String drinkType ="Black Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertTrue(expectedOutput);
	}

	@Test
	public void shouldShowMessageAsNoEnoughMaterialForNoOfCupCount(){
		Integer cupCount = 200;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertFalse(expectedOutput);
	}
	
	@Test
	public void shouldShowMessageWhenAmountToFillIsLessThanZeroToRefillContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = -1 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	
	@Test
	public void shouldRefillCoffeeContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillCoffeeContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldRefillTeaContainer(){

		Integer refillContainerChoice = 2; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill, false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillTeaContainer(){

		Integer refillContainerChoice = 2; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill ,false);
	}

	@Test
	public void shouldRefillWaterContainer(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillWaterContainer(){

		Integer refillContainerChoice = 3; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldRefillMilkContainer(){

		Integer refillContainerChoice = 4; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillMilkContainer(){

		Integer refillContainerChoice = 4; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill , false);
	}

	@Test
	public void shouldRefillSugarContainer(){

		Integer refillContainerChoice = 5; 
		Integer amountToFill = 10 ;
		Integer cupCount = 5;
		String drinkType ="Tea";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	

	
	@Test
	public void shouldShowMessageWhenContainerCurrentCapacityIsMaximumAndnotAbleToRefillSugarContainer(){

		Integer refillContainerChoice = 5; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}

	@Test
	public void shouldCheckSelectedChoiceIsInvalidToRefillContainer(){

		Integer refillContainerChoice = 6; 
		Integer amountToFill = 10 ;
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,false);
	}
	
	@Test
	public void shouldCheckTotalSaleForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldCheckContainerStatusForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.checkContainerStatusForVendingMachine();
	}
	
	@Test
	public void shouldResetContainerForVendingMachine(){

		Integer cupCount = 133;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		
		vendingMachineOperations.resetContainerForVendingMachine();
	}
	
	@Test
	public void shouldAddRefillCountInJsonObjToRefillContainer(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		
	}
	
	@Test
	public void shouldDisplayRefillCountFromJsonObjInTotalSaleReport(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldCheckNullForRefillCountFromJsonObjInTotalSaleReport(){

		Integer refillContainerChoice = 1; 
		Integer amountToFill = 10 ;
		Integer cupCount = 50;
		String drinkType ="Black Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.refillContainerForVendingMachine(refillContainerChoice, amountToFill,true);
		vendingMachineOperations.checkTotalSaleForVendingMachine();
	}
	
	@Test
	public void shouldAddTotalCupCountInJsonObjInMakeDrink(){

		Integer cupCountOne = 50;
		String drinkTypeOne ="Coffee";
		
		Integer cupCountTwo = 1;
		String drinkTypeTwo ="Coffee";

		vendingMachineOperations.makeDrinkForVendingMachine(drinkTypeOne,cupCountOne);
		vendingMachineOperations.makeDrinkForVendingMachine(drinkTypeTwo,cupCountTwo);
	}
	
	@Test
	public void shouldReturnFalseToMakeDrinkForZeroCupAsInput(){
		Integer cupCount = 0;
		String drinkType ="Coffee";

		Boolean expectedOutput = vendingMachineOperations.makeDrinkForVendingMachine(drinkType,cupCount);
		assertFalse(expectedOutput);
	}*/
}
