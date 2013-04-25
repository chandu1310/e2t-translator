package com.main.steps;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Tokenize {
	public static ArrayList<String> executeStep(String sentence){
		ArrayList<String> tokens = new ArrayList<String>();
	    for(String s: sentence.split("(?=[.,!? ])"))
	    {
//	        System.out.println(s.trim());
	    	if("".equals(s)||"\t".equals(s))
	    		continue;
	    	
	        tokens.add(s.trim());
	    }					
		return tokens;
	}
	
	
	public static void main(String[] args) {
		String s1 = "However, my trial with string-tokenizer also failed. How can I achieve this?";
	    //for(String s: s1.split("(?<=[().-,!;_:{}?[/-]\"\'])|(?=[().-,!;_:{}?[/-]\"\'])")){
	}
}
