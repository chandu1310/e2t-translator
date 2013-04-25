package com.main.steps;

import java.util.StringTokenizer;
import java.util.Vector;

public class Split { 
	public static Vector<String> executeStep(String sourceText){
		Vector<String> strV = new Vector<String>();
		
		StringTokenizer strTok = new StringTokenizer(sourceText, ".");
		while (strTok.hasMoreElements()) {
			String sentence = (String) strTok.nextElement();
			strV.add(sentence);
		}
		
		return strV;
	}
}
