package com.yash;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VendingMachineOperations implements VendingMachineOperationsInterface {


	private Map<String,Integer> containerUsedCapacityMap = new HashMap<>();
	private Map<String,Integer> containerRemainingCapacityMap = maximumContainerCapacityMap();

	@Override
	public void makeDrinkForVendingMachine(String drinkType, Integer cupCount) {

		Map<String,ContainerMaterialDTO> materialRequirementMap = getMaterialRequirement();
		Map<String,ContainerMaterialDTO> materialWasteMap = getWasteOfMaterial();

		Map<String,Integer> containerUsedTempMap = new HashMap<>();

		Integer totalCoffeeInContainer = 0 ,totalTeaInContainer = 0 ,
				totalSugarInContainer = 0 ,totalMilkInContainer = 0 , totalWaterInContainer =0;

		Boolean isContainerUnderflow = checkContainerIsUnderflow(drinkType);
		
		if(!isContainerUnderflow){
			for(int i = 0 ;i< cupCount; i++){
				
				totalCoffeeInContainer += materialRequirementMap.get(drinkType).getCoffee() + materialWasteMap.get(drinkType).getCoffee();;
				totalTeaInContainer += materialRequirementMap.get(drinkType).getTea() + materialWasteMap.get(drinkType).getTea();;
				totalSugarInContainer +=  materialRequirementMap.get(drinkType).getSugar() + materialWasteMap.get(drinkType).getSugar();;
				totalMilkInContainer +=  materialRequirementMap.get(drinkType).getMilk() +  materialWasteMap.get(drinkType).getMilk();;
				totalWaterInContainer +=  materialRequirementMap.get(drinkType).getWater() + materialWasteMap.get(drinkType).getWater();;
			}

			containerUsedTempMap.put("Tea", totalTeaInContainer );
			containerUsedTempMap.put("Coffee", totalCoffeeInContainer);
			containerUsedTempMap.put("Sugar", totalSugarInContainer);
			containerUsedTempMap.put("Milk", totalMilkInContainer);
			containerUsedTempMap.put("Water", totalWaterInContainer);

			updateContainerUsedAndRemainingData(containerUsedTempMap);
		}
		System.out.println("\nTotal Used : "+containerUsedCapacityMap);
		System.out.println("\nRemaining : "+containerRemainingCapacityMap);
	}



	private void updateContainerUsedAndRemainingData(Map<String,Integer> containerUsedTempMap) {

		Integer isToUpdateInContainerCount = 0;
		Map<String , Integer> maximumContainerCapacityMap = maximumContainerCapacityMap();
		/*maximumContainerCapacityMap.keySet().forEach(key -> {
				if(containerUsedTempMap.get(key) < maximumContainerCapacityMap.get(key)){
					isToUpdateInContainerCount++;
					System.out.println("No enough"+ key +" in Container");
				}
		});*/

		for(String key : maximumContainerCapacityMap.keySet()){
			Optional<Integer> optional = Optional.ofNullable(containerUsedCapacityMap.get(key));
			Integer usedCapacity = containerUsedTempMap.get(key);
			if(optional.isPresent()){
				usedCapacity +=  containerUsedCapacityMap.get(key);
			};

			if(usedCapacity > maximumContainerCapacityMap.get(key)){
				isToUpdateInContainerCount++;
				System.out.println("No enough "+ key +" in Container");
			}
		}
		if(isToUpdateInContainerCount == 0){
			maximumContainerCapacityMap.keySet().forEach(key -> {

				Optional<Integer> optional = Optional.ofNullable(containerUsedCapacityMap.get(key));
				Integer usedCapacity = containerUsedTempMap.get(key);
				if(optional.isPresent()){
					usedCapacity +=  containerUsedCapacityMap.get(key);
				};

				containerUsedCapacityMap.put(key, usedCapacity);
				containerRemainingCapacityMap.put(key, maximumContainerCapacityMap.get(key) - usedCapacity);
			});

		}
	}

	private Boolean checkContainerIsUnderflow(String drinkType) {

		Boolean isContainerUnderflow = false;
		if(containerRemainingCapacityMap.get("Coffee") == 0 && !drinkType.equalsIgnoreCase("Tea") && !drinkType.equalsIgnoreCase("Black Tea")){
			System.out.println("Coffee in Container is underflow");
			isContainerUnderflow = true;
		}

		if(containerRemainingCapacityMap.get("Tea") == 0 && !drinkType.equalsIgnoreCase("Coffee") && !drinkType.equalsIgnoreCase("Black Coffee")){
			System.out.println("Tea in Container is underflow");
			isContainerUnderflow = true;
		}
		if(containerRemainingCapacityMap.get("Sugar") == 0){
			System.out.println("Sugar in Container is underflow");
			isContainerUnderflow = true;
		}

		if(containerRemainingCapacityMap.get("Milk") == 0  && !drinkType.equalsIgnoreCase("Black Coffee")  && !drinkType.equalsIgnoreCase("Black Tea")){
			System.out.println("Milk in Container is underflow");
			isContainerUnderflow = true;
		}
		if(containerRemainingCapacityMap.get("Water") == 0){
			System.out.println("Water in Container is underflow");
			isContainerUnderflow = true;
		}
		return isContainerUnderflow;
	}

	@Override
	public void RefillContainerForVendingMachine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CheckTotalSaleForVendingMachine() {
		// TODO Auto-generated method stub

	}

	@Override
	public void CheckContainerStatusForVendingMachine() {

		System.out.println("Total Used : "+containerUsedCapacityMap);
		System.out.println("Remaining : "+containerRemainingCapacityMap);
	}

	@Override
	public void ResetContainerForVendingMachine() {

		containerRemainingCapacityMap = maximumContainerCapacityMap();
		containerUsedCapacityMap = new HashMap<>();

		System.out.println("Total Used : "+containerUsedCapacityMap);
		System.out.println("Remaining : "+containerRemainingCapacityMap);

	}

	public Map<String,Integer> maximumContainerCapacityMap(){
		
		Map<String,Integer> containerMaxCapacityMap = new HashMap<>();

		containerMaxCapacityMap.put("Tea", 2000);
		containerMaxCapacityMap.put("Coffee", 2000);
		containerMaxCapacityMap.put("Sugar", 8000);
		containerMaxCapacityMap.put("Milk", 35200);
		containerMaxCapacityMap.put("Water", 15000);
		return containerMaxCapacityMap;
	}
}

