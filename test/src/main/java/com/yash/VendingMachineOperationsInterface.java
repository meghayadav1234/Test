package com.yash;

import java.util.HashMap;
import java.util.Map;

public interface VendingMachineOperationsInterface {

	void makeDrinkForVendingMachine(String drinkType, Integer cupCount);

	void RefillContainerForVendingMachine();

	void CheckTotalSaleForVendingMachine();

	void CheckContainerStatusForVendingMachine();

	void ResetContainerForVendingMachine();
	
	public default Map<String,ContainerMaterialDTO> getMaterialRequirement(){
		Map<String,ContainerMaterialDTO> materialRequirementMap = new HashMap<>();
		
		ContainerMaterialDTO materialRequirementCoffee =new ContainerMaterialDTO(0, 4, 15, 20, 80);
		materialRequirementMap.put("Coffee", materialRequirementCoffee);
		
		ContainerMaterialDTO materialRequirementTea =new ContainerMaterialDTO(5, 0, 15, 60, 40);
		materialRequirementMap.put("Tea", materialRequirementTea);
		
		ContainerMaterialDTO materialRequirementBlackCoffee =new ContainerMaterialDTO(0, 3, 15, 100, 0);
		materialRequirementMap.put("Black Coffee", materialRequirementBlackCoffee);
		
		ContainerMaterialDTO materialRequirementBlackTea =new ContainerMaterialDTO(3, 0, 15, 100, 0);
		materialRequirementMap.put("Black Tea", materialRequirementBlackTea);
		
		return materialRequirementMap;
	}
	
	public default Map<String,ContainerMaterialDTO> getWasteOfMaterial(){
		Map<String,ContainerMaterialDTO> materialRequirementMap = new HashMap<>();
		
		ContainerMaterialDTO materialRequirementCoffee =new ContainerMaterialDTO(0, 1, 2, 3, 8);
		materialRequirementMap.put("Coffee", materialRequirementCoffee);
		
		ContainerMaterialDTO materialRequirementTea =new ContainerMaterialDTO(1, 0, 2, 5, 4);
		materialRequirementMap.put("Tea", materialRequirementTea);
		
		ContainerMaterialDTO materialRequirementBlackCoffee =new ContainerMaterialDTO(0, 0, 2, 12, 0);
		materialRequirementMap.put("Black Coffee", materialRequirementBlackCoffee);
		
		ContainerMaterialDTO materialRequirementBlackTea =new ContainerMaterialDTO(0, 0, 2, 12, 0);
		materialRequirementMap.put("Black Tea", materialRequirementBlackTea);
		
		return materialRequirementMap;
	}

}
