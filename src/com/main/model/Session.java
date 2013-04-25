package com.main.model;

import java.util.ArrayList;

public class Session {	
	
	public static final int RAW =0;
	public static final int SPLITTED =1;
	public static final int TOKENIZED =2;
	
	
	public static int state;
	
	public static ArrayList<String> sentences = new ArrayList<String>();	
	
	public static int nextSentenceToTokenize = -1;
	public static ArrayList tokenizedSentences = new ArrayList();
	
	public static String getNextSentenceForTokenizing(){
		String s = ""; 				
		if(nextSentenceToTokenize != -1 && nextSentenceToTokenize < sentences.size()){
			s = sentences.get(nextSentenceToTokenize);
			nextSentenceToTokenize++;
		}
		
		if(nextSentenceToTokenize == sentences.size()){
			state = TOKENIZED;
		}		
		return s;
	}
	
	public static String getTranslationText(){
		StringBuffer buffer = new StringBuffer();
		
		if(state == SPLITTED){
			for(int i=0; i<nextSentenceToTokenize;i++){
				ArrayList<String> tokens = (ArrayList<String>)tokenizedSentences.get(i);
				StringBuffer sb = new StringBuffer();
				for(String s : tokens){
					sb.append(s+" | ");
				}
				buffer.append(sb.toString()+"\n\n");
			}
			
			for(int i = nextSentenceToTokenize; i<sentences.size();i++){
				buffer.append(sentences.get(i)+"\n\n");
			}
		}
		
		if(state == TOKENIZED){
			for(Object o : tokenizedSentences){
				ArrayList<String> tokens = (ArrayList<String>)o;
				StringBuffer sb = new StringBuffer();
				for(String s : tokens){
					sb.append(s+" | ");
				}
				buffer.append(sb.toString()+"\n\n");
			}			
		}
		
		return buffer.toString();
	}
	
	public static void reset(){		
		sentences = new ArrayList<String>();
		tokenizedSentences = new ArrayList<>();
		nextSentenceToTokenize = -1;
		state = RAW;
	}
}
