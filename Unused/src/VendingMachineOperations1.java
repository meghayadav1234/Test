

import java.util.Map;

public class VendingMachineOperations1  {

	private ContainerMaterialDTO containerUsedCapacity = new ContainerMaterialDTO(0, 0, 0, 0, 0);
	private ContainerMaterialDTO containerRemainingCapacity = maximumContainerCapacity();

	public void makeDrinkForVendingMachine(String drinkType, Integer cupCount) {/*
		
		Map<String,ContainerMaterialDTO> materialRequirementMap = getMaterialRequirement();
		Map<String,ContainerMaterialDTO> materialWasteMap = getWasteOfMaterial();

		Integer totalCoffeeInContainer = containerUsedCapacity.getCoffee() ,totalTeaInContainer = containerUsedCapacity.getTea() ,
				totalSugarInContainer = containerUsedCapacity.getSugar()
				,totalMilkInContainer = containerUsedCapacity.getMilk() , totalWaterInContainer = containerUsedCapacity.getWater();

		Boolean isContainerUnderflow = checkContainerIsUnderflow(drinkType);
		if(!isContainerUnderflow){
			for(int i = 0 ;i< cupCount; i++){
				Integer remainingCoffeeInContainer = materialRequirementMap.get(drinkType).getCoffee() + materialWasteMap.get(drinkType).getCoffee();
				totalCoffeeInContainer += remainingCoffeeInContainer;

				Integer remainingTeaInContainer =  materialRequirementMap.get(drinkType).getTea() + materialWasteMap.get(drinkType).getTea();
				totalTeaInContainer += remainingTeaInContainer;

				Integer remainingSugarInContainer = materialRequirementMap.get(drinkType).getSugar() + materialWasteMap.get(drinkType).getSugar();
				totalSugarInContainer += remainingSugarInContainer;

				Integer remainingMilkInContainer = materialRequirementMap.get(drinkType).getMilk() +  materialWasteMap.get(drinkType).getMilk();
				totalMilkInContainer += remainingMilkInContainer;

				Integer remainingWaterInContainer = materialRequirementMap.get(drinkType).getWater() + materialWasteMap.get(drinkType).getWater();
				totalWaterInContainer += remainingWaterInContainer;
			}
			updateContainerUsedAndRemainingData(totalCoffeeInContainer,totalTeaInContainer,totalSugarInContainer,totalMilkInContainer,totalWaterInContainer);
		}
		System.out.println("\nTotal Used : "+containerUsedCapacity);
		System.out.println("\nRemaining : "+containerRemainingCapacity);
	*/}



	private void updateContainerUsedAndRemainingData(Integer totalCoffeeInContainer, Integer totalTeaInContainer, Integer totalSugarInContainer, Integer totalMilkInContainer, Integer totalWaterInContainer) {
		
		ContainerMaterialDTO containerMaximumCapacity =  maximumContainerCapacity();	
		Integer isToUpdateInContainerCount = 0;
		if(containerMaximumCapacity.getCoffee() < totalCoffeeInContainer){
			isToUpdateInContainerCount++;
			//System.out.println(totalCoffeeInContainer);
			System.out.println("No enough Coffee in Container");
		}

		if(containerMaximumCapacity.getTea() < totalTeaInContainer){
			isToUpdateInContainerCount++;
			//System.out.println(totalTeaInContainer);
			System.out.println("No enough Tea in Container");
		}

		if(containerMaximumCapacity.getSugar() < totalSugarInContainer){
			isToUpdateInContainerCount++;
			//System.out.println(totalSugarInContainer);
			System.out.println("No enough Sugar in Container");
		}

		if(containerMaximumCapacity.getMilk() < totalMilkInContainer){
			isToUpdateInContainerCount++;
			//System.out.println(totalMilkInContainer);
			System.out.println("No enough Milk in Container");
		}

		if(containerMaximumCapacity.getWater() < totalWaterInContainer){
			isToUpdateInContainerCount++;
			//System.out.println(totalWaterInContainer);
			System.out.println("No enough Water in Container");
		}		

		/*if(isToUpdateInContainerCount == 0){
			/containerUsedCapacity.setCoffee(totalCoffeeInContainer);
			containerRemainingCapacity.setCoffee(containerMaximumCapacity.getCoffee() - totalCoffeeInContainer);
			containerUsedCapacity.setTea(totalTeaInContainer);
			containerRemainingCapacity.setTea(containerMaximumCapacity.getTea() - totalTeaInContainer);
			containerUsedCapacity.setSugar(totalSugarInContainer);
			containerRemainingCapacity.setSugar(containerMaximumCapacity.getSugar() - totalSugarInContainer);
			containerUsedCapacity.setMilk(totalMilkInContainer);
			containerRemainingCapacity.setMilk(containerMaximumCapacity.getMilk() - totalMilkInContainer);
			containerUsedCapacity.setWater(totalWaterInContainer);
			containerRemainingCapacity.setWater(containerMaximumCapacity.getWater() - totalWaterInContainer);
		}*/
	}



	private Boolean checkContainerIsUnderflow(String drinkType) {

		Boolean isContainerUnderflow = false;
		if(containerRemainingCapacity.getCoffee() == 0 && !drinkType.equalsIgnoreCase("Tea") && !drinkType.equalsIgnoreCase("Black Tea")){
			System.out.println("Coffee in Container is underflow");
			isContainerUnderflow = true;
		}

		if(containerRemainingCapacity.getTea() == 0 && !drinkType.equalsIgnoreCase("Coffee") && !drinkType.equalsIgnoreCase("Black Coffee")){
			System.out.println("Tea in Container is underflow");
			isContainerUnderflow = true;
		}
		if(containerRemainingCapacity.getSugar() == 0){
			System.out.println("Sugar in Container is underflow");
			isContainerUnderflow = true;
		}

		if(containerRemainingCapacity.getMilk() == 0  && !drinkType.equalsIgnoreCase("Black Coffee")  && !drinkType.equalsIgnoreCase("Black Tea")){
			System.out.println("Milk in Container is underflow");
			isContainerUnderflow = true;
		}
		if(containerRemainingCapacity.getWater() == 0){
			System.out.println("Water in Container is underflow");
			isContainerUnderflow = true;
		}
		return isContainerUnderflow;
	}

	public void refillContainerForVendingMachine() {
		// TODO Auto-generated method stub

	}

	public void checkTotalSaleForVendingMachine() {
		// TODO Auto-generated method stub

	}

	public void checkContainerStatusForVendingMachine() {

		System.out.println("Total Used : "+containerUsedCapacity);
		System.out.println("Remaining : "+containerRemainingCapacity);
	}

	public void resetContainerForVendingMachine() {

		containerRemainingCapacity = maximumContainerCapacity();
		containerUsedCapacity = new ContainerMaterialDTO(0, 0, 0, 0, 0);

		System.out.println("Total Used : "+containerUsedCapacity);
		System.out.println("Remaining : "+containerRemainingCapacity);

	}

	public ContainerMaterialDTO maximumContainerCapacity(){

		ContainerMaterialDTO maximumContainerCapacity =new ContainerMaterialDTO();
		/*maximumContainerCapacity.setTea(2000);
		maximumContainerCapacity.setCoffee(2000);
		maximumContainerCapacity.setSugar(8000);
		maximumContainerCapacity.setWater(15000);
		maximumContainerCapacity.setMilk(35200);*/

		return maximumContainerCapacity;
	}
}

