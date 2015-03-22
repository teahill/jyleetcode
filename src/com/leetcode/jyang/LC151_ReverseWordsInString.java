package com.leetcode.jyang;

import java.util.StringTokenizer;

/**
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * 
 * @author jyang
 *
 */

public class LC151_ReverseWordsInString {
	public String reverseWords(String s) {
		
		if (s==null || s.length()==0){
			return s;
		}
		
		StringTokenizer st = new StringTokenizer(s, " ");
		
		String str = "";
		
		while (st.hasMoreTokens()){
			str = " " + st.nextToken() + str;
		}
	    
		return str.trim();
	}
}
