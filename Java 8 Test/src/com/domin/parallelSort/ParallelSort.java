package com.domin.parallelSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;

import com.domain.collector.EmplyeeCollector;

public class ParallelSort {

	public static void main(String[] args) {

		int array[]={9,2,1,4,8,6,7};
		Arrays.sort(array);
		Arrays.stream(array).forEach(x -> System.out.println(x));
		System.out.println("-------------------------");
		Arrays.parallelSort(array);
		Arrays.stream(array).forEach(x -> System.out.println(x));
		String stringArray[]= {"A","c","B","F","D"};
		System.out.println("-------------------------");
		//Arrays.parallelSort(stringArray);
		Arrays.stream(stringArray).forEach(x -> System.out.println(x));
		System.out.println("-----------Employee Array --------------");
		Comparator<EmplyeeCollector> comparator = Comparator.comparing(EmplyeeCollector::getEmployeeId).thenComparing(EmplyeeCollector::getEmployeeName);
		EmplyeeCollector empArray[] ={ new EmplyeeCollector(4, "A",10000.0),new EmplyeeCollector(2, "C",20000.0),new EmplyeeCollector(3, "B",30000.0)
				,new EmplyeeCollector(1, "D",40000.0),new EmplyeeCollector(2, "F",40000.0)};
		Arrays.stream(empArray).forEach(x -> System.out.println(x.getEmployeeId() +"  "+x.getEmployeeName()));
		/*System.out.println("----------Parallel Sort using Comparator-------");
		Arrays.parallelSort(empArray, comparator);
		Arrays.stream(empArray).forEach(x -> System.out.println(x.getEmployeeId() +"  "+x.getEmployeeName()));*/
		System.out.println("----------Parallel Sort with index-------");
		Arrays.parallelSort(empArray, 0, 4, comparator);
		Arrays.stream(empArray).forEach(x -> System.out.println(x.getEmployeeId() +"  "+x.getEmployeeName()));
		System.out.println("-------------------------");
		Arrays.parallelSort(stringArray, 0, 3);
		Arrays.stream(stringArray).forEach(x -> System.out.println(x));
		
		 StringJoiner sj = new StringJoiner(":", "[", "]");
		 sj.add("A").add("B").add("C");
		 System.out.println(sj.toString());
	}

}
