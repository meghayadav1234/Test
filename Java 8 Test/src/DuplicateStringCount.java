import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class DuplicateStringCount {

	public int wordCount(String input){
		String[] inputStringArray = input.split(",");
		int count = inputStringArray.length;
		//Arrays.sort(inputStringArray);
		
		Map<String, Integer> stringWordCount =new HashMap<String, Integer>();
		int wordCount = 1;
		for(int i = 0 ; i < inputStringArray.length ; i++){
			
			for(int j = i+1 ; j < inputStringArray.length ; j++){
				if(inputStringArray[i].equalsIgnoreCase(inputStringArray[j])){
					wordCount++;
				}
				if(wordCount >0){
					stringWordCount.put(inputStringArray[j],wordCount);
					wordCount = 1;
				}
			}
		}
		
		stringWordCount.entrySet().forEach(x-> System.out.println(x.getKey()+ x.getValue()));
		
		Map<String, Integer> stringWordCount1 =new HashMap<String, Integer>();
		for(String s : Arrays.asList(inputStringArray)){
			Integer i = stringWordCount1.get(s);
			stringWordCount1.put(s,(i==null ?1:i+1));
		}
		System.out.println("----------");
		stringWordCount1.entrySet().forEach(x-> System.out.println(x.getKey()+ x.getValue()));
		
		return count;
	}
	
	public static void main(String[] args){
		DuplicateStringCount w =new DuplicateStringCount();
		w.wordCount("Book,Book,new,new,A,Book");
	}
}
