package com.yash.domain;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args)  {
		
		/*Test t =new Test();
		System.out.println(t.checkException());
		List<Integer> list = new ArrayList<Integer>();
		System.out.println(list.size());
		System.out.println(list);*/
		
	/*	try(FileOutputStream fileOutputStream = new FileOutputStream("C:/STS Workspace/TryWithResource")){
			
			String msg = "Hello";
			byte byteArray[]=msg.getBytes();
			fileOutputStream.write(byteArray);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}*/
		
		try{
		 int array[] = new int[1];    
         array[100] = 30/1;    
		}catch(ArithmeticException  | ArrayIndexOutOfBoundsException exception){
			System.out.println(exception);
		}
		
		String game = "Cricket";  
        switch(game){  
        case "Hockey":  
            System.out.println("Let's play Hockey");  
            break;  
        case "Cricket":  
            System.out.println("Let's play Cricket");  
            break;  
        case "Football":  
            System.out.println("Let's play Football");  
        }  
        
        int a = 1_0;  
        System.out.println("a = "+a);  
        
        float b = 10.5_1220f;  
        System.out.println("b = "+b);
	}

	public String checkException(){
		String str= null;
		try{
			str ="try";
			
		}catch(Exception e){
			str ="catch";
		}finally{
			str = "finally";
		}
		return str;
	}
}

