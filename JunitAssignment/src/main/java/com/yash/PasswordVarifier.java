package com.yash;

import java.util.regex.Pattern;

public class PasswordVarifier {

	public Boolean passwordVarify(String input){

		Boolean isVarify = false;
	
		if(input != null && input.length() > 8 && input.matches(".*[0-9].*") && input.matches(".*[A-Z].*") && input.matches(".*[a-z].*")){
			return true;
		}
		return false;
	}

	

	public Boolean passwordVerifyByThreeConditionsMust(String input){

		int count = 0;
	
		if(input != null){
			count++;
			if(input.matches(".*[a-z].*")){
				count++;
				if(input.length() > 8 || input.matches(".*[0-9].*") || input.matches(".*[A-Z].*")){
					count++;
				}
			}else{
				throw new MyRuntimeException("Password should contain atleast one lower case letter.");
			}
		}else{
			throw new MyRuntimeException("Password should not be null.");
		}
		
		if(count < 3){
			throw new MyRuntimeException("password is never ok.");
		}
		return true;
	}
}
