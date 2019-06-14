package com.domain.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test implements X,Y{
	public void method1()   {
		System.out.println("ssssssss");
	}
	 public static String s = "Hi";
		void doSomething(String p) {
		s= "Hello";
		}
	public static void main(String[] args) throws Exception {

	/*final List<Integer> list  = new ArrayList<>();
	list.add(1);
	list.add(2);
	list.add(3);
	list.forEach(x-> System.out.println(x));
	final List<Integer> list1 = Collections.unmodifiableList(list);
	list1.add(6);
	
	list.forEach(x-> System.out.println(x));
	*/
	Test a = new Test();
	
	a.doSomething("abc");
	System.out.println(s);
		/*String inputNumber = "//;\n1;23;2;344"+"_";
		Integer addition = 0;
		String inputNumberString = inputNumber + "_";
		if(inputNumber.equals("")){
			System.out.println(0);
		}else{
			char[] inputStringCharArray = inputNumberString.toCharArray();
			
			List<String> list = new ArrayList<>();
			StringBuilder s = new StringBuilder();
			for(int i=0 ;i < inputStringCharArray.length ;i++){
				 String stringNumber= Character.toString(inputStringCharArray[i]);
				if(Character.isDigit(inputStringCharArray[i]) || stringNumber.equals("-")){
					s.append(inputStringCharArray[i]);
				}else{
					if(s.length() > 0)
					list.add(s.toString());
					s=new StringBuilder();
				}
			}
			List<Integer> negativeNoList = new ArrayList<>();
			Boolean isNegative = false;
			for(String stringNumber : list){
				System.out.println(stringNumber);
				Integer number = Integer.valueOf(stringNumber); 
				if(number < 0){
					isNegative = true;
					negativeNoList.add(number);
				}else if(number <= 1000){
					addition += number ;	
				}
			}
			if(isNegative){
				System.out.println(negativeNoList);
				throw new Exception("Negatives not allowed"+negativeNoList);
			}
			System.out.println(addition);
		}*/
	
		
		
		/*List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(13);
		list.add(6);
		list.add(3);
		list.add(20);
		list.add(2);
		list.forEach(x -> System.out.println(x));
		System.out.println("Sorted List is : " );
		list.stream().sorted().forEach(x -> System.out.println(x));
		C c=new C();
		Test.show(c);*/
		/*String inputNumberString = "//;\n1;23;2;344"+"_";
		Integer addition =0;
		char[] inputStringCharArray = inputNumberString.toCharArray();
		List<String> list = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		for(int i=0 ;i < inputStringCharArray.length ;i++){
			 String stringNumber= Character.toString(inputStringCharArray[i]);
			if(Character.isDigit(inputStringCharArray[i]) || stringNumber.equals("-")){
				s.append(inputStringCharArray[i]);
			}else{
				if(s.length() > 0)
				list.add(s.toString());
				s=new StringBuilder();
			}
		}
		System.out.println("-------------");
		for(String stringNumber : list){
			System.out.println(stringNumber);
			addition = Integer.valueOf(stringNumber)+ addition;
		}
		*/
		/*String inputNumberString = "//;\n1;23;-2;344";
		Integer addition =0;
		String[] inputStringArray = inputNumberString.split("\\n|,");
		String delimiter = "//\n";
		StringTokenizer multiTokenizer = new StringTokenizer(inputNumberString, delimiter+";");
		 
		while (multiTokenizer.hasMoreTokens())
		{
		    String inputNoString = multiTokenizer.nextToken();
		    System.out.println(inputNoString);
		}*//*
		for(String inputNumber : Arrays.asList(inputStringArray)){
			addition = Integer.valueOf(inputNumber)+ addition;
		}
		*/
		/*char[] inputStringCharArray = inputNumberString.toCharArray();
		for(int i=0 ;i < inputStringCharArray.length ;i++){
			if(Character.isDigit(inputStringCharArray[i])){
				System.out.println(inputStringCharArray[i]);
				int number = Character.getNumericValue(inputStringCharArray[i]);
				addition = Integer.valueOf(number)+ addition;
			}
		}*/
	}
	
	/*public static void show(A a){
		System.out.println("In A object");
	}
	public static void show(B b){
		System.out.println("In B object");
	}
	public static void show(Object o){
		System.out.println("In object");
	}*/
}
/*
class A{
	
}
class B extends A{
	
}
class C extends A{
	
}*/

interface X {
public void method1() throws SQLException;
}

interface Y {
public void method1() throws IOException;
}





