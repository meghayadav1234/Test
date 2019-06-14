

public class TeaCoffeeVendingMachineMenu {
	ScannerTeaCoffeeMachine scanner = new ScannerTeaCoffeeMachine();

	VendingMachineOperationsInterface VendingMachineOperationsInterface = new VendingMachineOperations();

	public void DisplayMenuForTeaCoffeeVendingMachine(Boolean isContinueFalg) {
		do{
			System.out.println("\nMenu : ");
			System.out.println("1. Coffee"
					+ "\n2. Tea"
					+ "\n3. Black Coffee"
					+ "\n4. Black Tea"
					+ "\n5. Refill Container"
					+ "\n6. Check Total Sale"
					+ "\n7. Container Status"
					+ "\n8. Reset Container"
					+ "\n9. Exit");

			System.out.println("\nSelect Menu :");
			Boolean isSucess = false;
			Integer menuChoice = scanner.nextInt();
			Integer cupCount = null;
			switch(menuChoice){

			case 1 : 
				System.out.println("\nCup Count :");
				cupCount = scanner.nextInt();
				isSucess = VendingMachineOperationsInterface.makeDrinkForVendingMachine("Coffee",cupCount);
				if(isSucess){
					System.out.println(" Coffee is Ready");
				}

				break;
			case 2 : 
				System.out.println("\n Cup Count :");
				cupCount = scanner.nextInt();
				isSucess = VendingMachineOperationsInterface.makeDrinkForVendingMachine("Tea",cupCount);
				if(isSucess){
					System.out.println(" Tea is Ready");
				}
				break;
			case 3 : 
				System.out.println("\n Cup Count :");
				cupCount = scanner.nextInt();
				isSucess = VendingMachineOperationsInterface.makeDrinkForVendingMachine("Black Coffee",cupCount);
				if(isSucess){
					System.out.println(" Black Coffee is Ready");
				}
				break;
			case 4 : 
				System.out.println("\n Cup Count :");
				cupCount = scanner.nextInt();
				isSucess = VendingMachineOperationsInterface.makeDrinkForVendingMachine("Black Tea",cupCount);
				if(isSucess){
					System.out.println(" Black Tea is Ready");
				}
				break;
			case 5 : 
				Boolean isContinueToRefillContainer = false;
				do{
					System.out.println("Select Option to refill container : ");
					System.out.println("1. Coffee Container"
							+ "\n2. Tea Container"
							+ "\n3. Water Container"
							+ "\n4. Milk Container"
							+ "\n5. Sugar Container"
							+ "\n6. Back to Menu");
					Integer refillContainerChoice = scanner.nextInt();
					if(refillContainerChoice == 6){
						isContinueToRefillContainer = false;
					}else{
						System.out.println(" Enter quantity to fill container :");
						Integer amountToFill = scanner.nextInt();
						VendingMachineOperationsInterface.refillContainerForVendingMachine(refillContainerChoice,amountToFill);
						System.out.println(" Do you want to continue refill container press 1 otherwise 0.");
						isContinueToRefillContainer = (scanner.nextInt() == 1) ? true : false;
					}
				}while(isContinueToRefillContainer);
				break;
			case 6 : 
				VendingMachineOperationsInterface.checkTotalSaleForVendingMachine();
				break;
			case 7 : 
				VendingMachineOperationsInterface.checkContainerStatusForVendingMachine();
				break;
			case 8 : 
				VendingMachineOperationsInterface.resetContainerForVendingMachine();
				break;
			case 9 : 
				isContinueFalg = false;
				break;
			default:
				System.out.println("Invalid Choice");
			}
		}while(isContinueFalg);

	}


}
