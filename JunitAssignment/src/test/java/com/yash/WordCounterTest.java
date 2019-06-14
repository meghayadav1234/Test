package com.yash;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
public class WordCounterTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void wordCounterTest() {
		WordCounter wordCounter =new WordCounter();
		String input ="Book,Book,Pen";
		Map<String, Integer> ExpectedWordCount =new HashMap<String, Integer>();
		ExpectedWordCount.put("Book",2);
		ExpectedWordCount.put("Pen",1);
		assertEquals(ExpectedWordCount, wordCounter.wordCount(input,","));
	}
	
	@Test
	public void wordCounterNoCommaAsDelimiterTest() {
		WordCounter wordCounter =new WordCounter();
		String input ="Book Book Pen";
		Map<String, Integer> ExpectedWordCount =new HashMap<String, Integer>();
		ExpectedWordCount.put("Book",2);
		ExpectedWordCount.put("Pen",1);
		assertEquals(ExpectedWordCount, wordCounter.wordCount(input," "));
	}
	
	@Test
	public void wordCounterSpaceAsDelimiterTest() {
		WordCounter wordCounter =new WordCounter();
		String input ="Book Book Pen";
		Map<String, Integer> ExpectedWordCount =new HashMap<String, Integer>();
		ExpectedWordCount.put("Book",2);
		ExpectedWordCount.put("Pen",1);
		assertEquals(ExpectedWordCount, wordCounter.wordCount(input," "));
	}
	
	@Test
	public void wordCounterNoSpaceAsDelimiterTest() {
		WordCounter wordCounter =new WordCounter();
		String input ="Book Book Pen";
		//ExpectedWordCount.put("Book",2);
		//ExpectedWordCount.put("Pen",1);
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Input Not Null.");
		wordCounter.wordCount(input,null);
	}
	
	@Test
	public void wordCounterForInputNullValueTest() {
		WordCounter wordCounter =new WordCounter();
		String input =null;
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("Input Not Null.");
		wordCounter.wordCount(input," ");
	}
	
	
}
