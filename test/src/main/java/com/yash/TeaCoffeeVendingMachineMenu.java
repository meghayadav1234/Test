package com.yash;

public class TeaCoffeeVendingMachineMenu {
	ScannerTeaCoffeeMachine scanner = new ScannerTeaCoffeeMachine();

	public void DisplayMenuForTeaCoffeeVendingMachine(Boolean isContinueFalg) {
		VendingMachineOperationsInterface VendingMachineOperationsInterface =new VendingMachineOperations();
		do{
			System.out.println("\nMenu : ");
			System.out.println("1.Coffee"
					+ "\n2.Tea"
					+ "\n3.Black Coffee"
					+ "\n4.Black Tea"
					+ "\n5.Refill Container"
					+ "\n6.Check Total Sale"
					+ "\n7.Container Status"
					+ "\n8.Reset Container"
					+ "\n9.Exit");

			System.out.println("\nEnter Order :");
			
			Integer option = scanner.nextInt();
			Integer cupCount = null;

			switch(option){
			case 1 : 
				System.out.println("\nCup Count :");
				cupCount = scanner.nextInt();
				VendingMachineOperationsInterface.makeDrinkForVendingMachine("Coffee",cupCount);
				break;
			case 2 : 
				System.out.println("\nCup Count :");
				cupCount = scanner.nextInt();
				VendingMachineOperationsInterface.makeDrinkForVendingMachine("Tea",cupCount);
				break;
			case 3 : 
				System.out.println("\nCup Count :");
				cupCount = scanner.nextInt();
				VendingMachineOperationsInterface.makeDrinkForVendingMachine("Black Coffee",cupCount);
				break;
			case 4 : 
				System.out.println("\nCup Count :");
				cupCount = scanner.nextInt();
				VendingMachineOperationsInterface.makeDrinkForVendingMachine("Black Tea",cupCount);
				break;
			case 5 : 
				VendingMachineOperationsInterface.RefillContainerForVendingMachine();
				break;
			case 6 : 
				VendingMachineOperationsInterface.CheckTotalSaleForVendingMachine();
				break;
			case 7 : 
				VendingMachineOperationsInterface.CheckContainerStatusForVendingMachine();
				break;
			case 8 : 
				VendingMachineOperationsInterface.ResetContainerForVendingMachine();
				break;
			default:
				isContinueFalg = false;
				System.exit(0);
			}
		}while(isContinueFalg);

	}
}
