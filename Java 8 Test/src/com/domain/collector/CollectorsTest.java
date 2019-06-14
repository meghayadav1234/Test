package com.domain.collector;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsTest {

	public static void main(String[] args) {

		List<EmplyeeCollector> employeeList = new ArrayList<EmplyeeCollector>();
		employeeList.add(new EmplyeeCollector(1, "A",10000.0));
		employeeList.add(new EmplyeeCollector(2, "B",20000.0));
		employeeList.add(new EmplyeeCollector(2, "C",30000.0));
		employeeList.add(new EmplyeeCollector(4, "D",40000.0));
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(4);
		list.add(4);
		list.add(2);
		list.add(5);
		
		Map<Boolean,List<Integer>>  partioningList =  list.stream().collect(Collectors.partitioningBy(x -> x >3));
		partioningList.entrySet().forEach(x -> System.out.println(x));
		Double i = list.stream().collect(Collectors.averagingInt( x-> x));
		System.out.println(i);
		Map<Boolean,Long>  partioningList2 =  list.stream().collect(Collectors.partitioningBy(x -> x >3, Collectors.counting()));
		partioningList2.entrySet().forEach(x -> System.out.println(x));
		System.out.println("------------------------------");
		Map<Object, Integer> map = list.stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue,(x, y) ->y ));
		map.entrySet().forEach(x -> System.out.println(x));
/*		System.out.println("-----------java.lang.IllegalStateException: Duplicate key 4-----");
		Map<Object, Integer> map1 = list.stream().collect(Collectors.toMap(Integer::intValue, Function.identity(),(x, y) -> x + y));
		map1.entrySet().forEach(x -> System.out.println(x));*/
		
		/*Map<Object, Integer> map1 = list.stream().collect(Collectors.toMap(Integer::intValue, Integer::intValue,(x, y) -> x+','+y, LinkedHashMap::new));
		map1.entrySet().forEach(x -> System.out.println(x));*/
		System.out.println("------------------------------");
		Map<Integer, String> map1 = employeeList.stream().collect(Collectors.toMap(EmplyeeCollector::getEmployeeId, EmplyeeCollector::getEmployeeName, (x, y) -> x+','+y));
		map1.entrySet().forEach(x -> System.out.println(x));
		System.out.println("------------------------------");
		
		
/*String input ="Boom,Boom,a";
		String[] inputStringArray = input.split(",");
		int count = inputStringArray.length;
		Map<String, Integer> stringWordCount =new HashMap<String, Integer>();
		int wordCount = 0;
		for(int k = 0 ; k < inputStringArray.length ; k++){
			for(int j = 0 ; j < inputStringArray.length ; j++){
				if(inputStringArray[k].equalsIgnoreCase(inputStringArray[j]) && k != j){
					wordCount++;
				}

			}
			if(wordCount >0){
				stringWordCount.put(inputStringArray[k],wordCount);
			}
		}
		
		stringWordCount.entrySet().forEach(x-> System.out.println(x.getKey()+ x.getValue()));
	*/
		
	}

}
