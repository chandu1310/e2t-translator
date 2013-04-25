package com.main.steps;

import java.util.StringTokenizer;
import java.util.Vector;

public class Split { 
	public static Vector<String> executeStep(String sourceText){
		Vector<String> strV = new Vector<String>();
		
		StringTokenizer strTok = new StringTokenizer(sourceText, ".");
		while (strTok.hasMoreElements()) {
			String sentence = (String) strTok.nextElement();
			
			char c = sentence.charAt(sentence.length()-1);
			if( Character.isAlphabetic(c) || Character.isDigit(c) )
				sentence = sentence+".";
			
			strV.add(sentence);
		}
		
		return strV;
	}
}
