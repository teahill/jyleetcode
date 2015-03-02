package com.leetcode.jyang;

/**
 * Level: Easy
 * 
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * @author jyang
 *
 */

public class LC014_LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		
		if (strs == null || strs.length==0){
			return "";
		}
		
		String r = "";
		
		String first = strs[0];
		
		if (first.isEmpty()){
			return r;
		}
		
		for (int i=0; i<first.length(); i++) {
			
			char c = first.charAt(i);
			
			for (int j=1; j<strs.length; j++) {
				
				String str = strs[j];
				
				if (i>=str.length()) {
					return r;
				}
				
				if (str.charAt(i)!=c){
					return r;
				}
			}
			
			r += String.valueOf(c);
		}
		
	    return r;
	}
	
}
