

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class VendingMachineOperations implements VendingMachineOperationsInterface {
	
	private final static Logger logger = LogManager.getLogger(VendingMachineOperations.class);

	private Map<String,Integer> containerRemainingCapacityMap = maximumContainerCapacityMap();

	private JsonObject jsonObject = new JsonObject();

	@Override
	public Boolean makeDrinkForVendingMachine(String drinkType, Integer cupCount) {

		Boolean isSucess = false;
		if(cupCount > 0 ){
			Map<String,ContainerMaterialDTO> materialRequirementMap = getMaterialRequirementIncludingWaste();
			Integer totalCupCount = cupCount;
			JsonArray  jsonArray = new JsonArray();
			Map<String,Integer> containerUsedTempMap = new HashMap<>();

			containerUsedTempMap.put("Tea", materialRequirementMap.get(drinkType).getTea() * cupCount);
			containerUsedTempMap.put("Coffee", materialRequirementMap.get(drinkType).getCoffee() * cupCount);
			containerUsedTempMap.put("Sugar", materialRequirementMap.get(drinkType).getSugar() *cupCount);
			containerUsedTempMap.put("Milk", materialRequirementMap.get(drinkType).getMilk() * cupCount);
			containerUsedTempMap.put("Water", materialRequirementMap.get(drinkType).getWater() * cupCount);

			if(updateUsedAndRemainingContainerCapacity(containerUsedTempMap, cupCount)){
				Optional<JsonElement> optional = Optional.ofNullable(jsonObject.get(drinkType));
				if(optional.isPresent()){
					totalCupCount +=jsonObject.get(drinkType).getAsInt();
				}
				jsonArray.add(totalCupCount);
				jsonObject.add(drinkType,  jsonArray);
				isSucess = true;
			}
		}
		return isSucess;
	}

	@Override
	public void refillContainerForVendingMachine(Integer refillContainerChoice, Integer amountToFill, Boolean isCalledFromMainMenu) {

		Integer refillContainerCount = 0;
		Optional<JsonElement> optional = Optional.ofNullable(jsonObject.get("Refill Count"));
		if(optional.isPresent()){
			refillContainerCount = jsonObject.get("Refill Count").getAsInt();
		}
		Map<String , Integer> maximumContainerCapacityMap = maximumContainerCapacityMap();
		String key = null;
		if(refillContainerChoice == 1 ){
			key = "Coffee" ;
		}else if(refillContainerChoice == 2){
			key = "Tea" ;
		}else if(refillContainerChoice == 3){
			key = "Water" ;
		}else if(refillContainerChoice == 4){
			key = "Milk" ;
		}else if(refillContainerChoice == 5){
			key = "Sugar" ;
		}
		Optional<String> optionalKey = Optional.ofNullable(key);
		if(optionalKey.isPresent()){
			Integer containerEmptyAmout = maximumContainerCapacityMap.get(key) - containerRemainingCapacityMap.get(key);
			if(amountToFill < 0){
				logger.info("Amount should be greater than zero.");
			}else if(amountToFill > containerEmptyAmout){
				logger.info("Container Maximum capacity is "+ maximumContainerCapacityMap.get(key) +" And you can fill only " + containerEmptyAmout + " amount.");
			}else{
				Integer refillAmount = containerRemainingCapacityMap.get(key) + amountToFill;
				containerRemainingCapacityMap.put(key , refillAmount);
				logger.info(amountToFill  + " quantity added in "+ key + " Container.");
				if(isCalledFromMainMenu){
					refillContainerCount++;
					jsonObject.addProperty("Refill Count",refillContainerCount);
				}
			}
		}else{
			logger.info("Invalid Choice");
		}
	}

	@Override
	public void checkTotalSaleForVendingMachine() {

		Map<String,Integer> drinkCostPerCup = getCostOfDrinkPerEachCupForVendingMachine();
		Map<String,ContainerMaterialDTO> materialWaste = getWasteOfMaterial();
		Integer totalCup = 0, totalPrice = 0;
		Integer totalSugarWaste = 0, totalMilkWaste = 0, totalTeaWaste = 0 , totalCoffeeWaste = 0 ,totalWaterWaste = 0;
		
		logger.info("---------------Total Tea-Coffee Sale Report Drink Wise-------------------");
		for(Entry<String, Integer> drinkType : drinkCostPerCup.entrySet()){
			Optional<JsonElement> optional = Optional.ofNullable(jsonObject.get(drinkType.getKey()));
			if(optional.isPresent()){
				ContainerMaterialDTO  containerMaterialDTO =  materialWaste.get(drinkType.getKey());
				
				logger.info("\nDrink Type : "+ drinkType.getKey()); 
				Integer cupCount = jsonObject.get(drinkType.getKey()).getAsInt();
				totalCup += cupCount;
				totalPrice += drinkType.getValue() * jsonObject.get(drinkType.getKey()).getAsInt();

				totalMilkWaste += cupCount * containerMaterialDTO.getMilk();
				totalWaterWaste += cupCount * containerMaterialDTO.getWater();
				totalSugarWaste += cupCount * containerMaterialDTO.getSugar();
				totalTeaWaste += cupCount * containerMaterialDTO.getTea();
				totalCoffeeWaste += cupCount * containerMaterialDTO.getCoffee();

				logger.info("\tCup Count : "+ cupCount);
				logger.info("\tPrice : "+ drinkType.getValue() * jsonObject.get(drinkType.getKey()).getAsInt());

				logger.info("\nTotal Drinkwise Waste : ");
				logger.info("\tMilk Container -: "+ cupCount * containerMaterialDTO.getMilk());
				logger.info("\tWater Container -: "+ cupCount * containerMaterialDTO.getWater());
				logger.info("\tSugar Container -: "+ cupCount * containerMaterialDTO.getSugar());
				logger.info("\tTea Container -: "+ cupCount * containerMaterialDTO.getTea());
				logger.info("\tCoffee Container -: "+ cupCount* containerMaterialDTO.getCoffee());
			}
		}
		logger.info("\n----------Total Tea-Coffee Sale Report----------------");
		logger.info("Total Cup : "+ totalCup);
		logger.info("Total Price : "+ totalPrice);
		logger.info("Total Current Container Capacity  : ");
		containerRemainingCapacityMap.entrySet().forEach(x -> logger.info(x.getKey() +" --> "+"\tUsed : "+ jsonObject.get("MaxSize"+x.getKey()) + "\tRemaining : "+x.getValue()));
		logger.info("\nTotal Container Waste : ");
		logger.info("\tMilk Container -: "+ totalMilkWaste);
		logger.info("\tWater Container -: "+ totalWaterWaste);
		logger.info("\tSugar Container -: "+ totalSugarWaste);
		logger.info("\tTea Container -: "+ totalTeaWaste);
		logger.info("\tCoffee Container -: "+ totalCoffeeWaste + "\n");
		
		Optional<JsonElement> optional = Optional.ofNullable(jsonObject.get("Refill Count"));
		if(optional.isPresent()){
			logger.info("\nRefill Count  :"+ jsonObject.get("Refill Count").getAsInt() + "\n");
		}
	}

	@Override
	public void checkContainerStatusForVendingMachine() {

		logger.info("Total Current Container Capacity  : ");
		containerRemainingCapacityMap.entrySet().forEach(x -> logger.info(x.getKey() +" --> "+"\tUsed : "+ jsonObject.get("MaxSize"+x.getKey()) + "\tRemaining : "+x.getValue()));

	}

	@Override
	public void resetContainerForVendingMachine() {

		containerRemainingCapacityMap = maximumContainerCapacityMap();
		//containerUsedCapacityMap = new HashMap<>();
		maximumContainerCapacityMap().entrySet().forEach(x -> jsonObject.addProperty("MaxSize"+x.getKey(), 0));
		

		logger.info("Current Container Capacity : ");
		containerRemainingCapacityMap.entrySet().forEach(x -> logger.info("\t"+ x.getKey() +" : "+ x.getValue()));
	}

	private Map<String,Integer> maximumContainerCapacityMap(){

		Map<String,Integer> containerMaxCapacityMap = new HashMap<>();
		containerMaxCapacityMap.put("Tea", 2000);
		containerMaxCapacityMap.put("Coffee", 2000);
		containerMaxCapacityMap.put("Sugar", 8000);
		containerMaxCapacityMap.put("Milk", 10000);
		containerMaxCapacityMap.put("Water", 15000);
		return containerMaxCapacityMap;
	}

	private Boolean updateUsedAndRemainingContainerCapacity(Map<String,Integer> containerUsedTempMap ,Integer cupCount) {

		Integer isToUpdateInContainerCount = 0;
		Boolean isSucess = false;
		Map<String , Integer> maximumContainerCapacityMap = maximumContainerCapacityMap();
		
		for(String key : maximumContainerCapacityMap.keySet()){
			if(containerUsedTempMap.get(key) > containerRemainingCapacityMap.get(key)){
				isToUpdateInContainerCount++;
				logger.info("No enough quantity in "+ key +" Container");
			}
		}
		if(isToUpdateInContainerCount == 0){
			maximumContainerCapacityMap.keySet().forEach(key -> {
				//Optional<Integer> optional = Optional.ofNullable(containerUsedCapacityMap.get(key));
				Optional<JsonElement> optional = Optional.ofNullable(jsonObject.get("MaxSize"+key));
				Integer usedCapacity = containerUsedTempMap.get(key) ;
				if(optional.isPresent()){
					usedCapacity += jsonObject.get("MaxSize"+key).getAsInt()  ;
							//containerUsedCapacityMap.get(key) ;
				};
				//containerUsedCapacityMap.put(key, usedCapacity);
				//jsonArray.add(usedCapacity);
				jsonObject.addProperty("MaxSize"+key, usedCapacity);
				containerRemainingCapacityMap.put(key, containerRemainingCapacityMap.get(key) - containerUsedTempMap.get(key));
			});
			isSucess = true;
		}
		return isSucess;
	}
}

