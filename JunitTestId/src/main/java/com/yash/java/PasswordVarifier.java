package com.yash.java;

public class PasswordVarifier {

	public Boolean passwordVarify(String input){

		/*Boolean isVarify = true;
		if(input != null){
			if(input.length() < 8){
				isVarify = false;
			}else if(!checkStringContainsAtleastOneUpperCaseLetter(input)){
				isVarify = false;
			}else if(!checkStringContainsAtleastOneLowerCaseLetter(input)){
				isVarify = false;
			}else if(!checkStringContainsAtleastOneNumberLetter(input)){
				isVarify = false;
			}
		}else{
			isVarify = false;
		}		*/
		Boolean isVarify = false;
		String numRegex   = ".*[0-9].*";
		String upperLetterRegex = ".*[A-Z].*";
		String lowerLetterRegex = ".*[a-z].*";
		if(input != null && input.length() < 8 && input.matches(numRegex) && input.matches(upperLetterRegex) && input.matches(lowerLetterRegex)){
			isVarify = true;
		}
		return isVarify;
	}

	private  boolean checkStringContainsAtleastOneUpperCaseLetter(String str) {
		char ch;
		for(int i=0;i < str.length();i++) {
			ch = str.charAt(i);
			if (Character.isUpperCase(ch)) {
				return true;
			}
		}
		return false;
	}
	private  boolean checkStringContainsAtleastOneLowerCaseLetter(String str) {
		char ch;
		for(int i=0;i < str.length();i++) {
			ch = str.charAt(i);
			if (Character.isLowerCase(ch)) {
				return true;
			}
		}
		return false;
	}
	private  boolean checkStringContainsAtleastOneNumberLetter(String str) {
		char ch;
		for(int i=0;i < str.length();i++) {
			ch = str.charAt(i);
			if (Character.isDigit(ch)) {
				return true;
			}
		}
		return false;
	}


	public Boolean passwordVerifyByThreeConditionsMust(String input){

		int count = 0;
		Boolean isLowerCase = false;
		if(input != null){
			count++;
		}else{
			throw new MyRuntimeException("Password should not be null.");
		}
		if(input.length() > 8){
			count++;
		}
		if(checkStringContainsAtleastOneUpperCaseLetter(input)){
			count++;
		}
		if(checkStringContainsAtleastOneLowerCaseLetter(input)){
			count++;
			isLowerCase =true;
		}
		if(checkStringContainsAtleastOneNumberLetter(input)){
			count++;
		}
		if((count < 3) && isLowerCase){
			throw new MyRuntimeException("password is never ok.");
		}
		return true;
	}
}
