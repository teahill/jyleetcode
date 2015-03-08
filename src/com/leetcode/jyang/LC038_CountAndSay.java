package com.leetcode.jyang;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * 
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 * 
 * 1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211,
 * 
 * @author jyang
 *
 */

public class LC038_CountAndSay {

	public String countAndSay(int n) {
		
		if (n==1){
			return "1";
		}
		
		String s1 = "1";
		String s2 = "";
		
		int count = 1;
		
		while (count<n){
			
			s2 = "";
			
			for (int i=0; i<s1.length();){
				int ct = 1;
				char c = s1.charAt(i);
				
				while (i+1<s1.length() && s1.charAt(i)==s1.charAt(i+1)){
					ct++;
					i++;
				}
				
				s2 += ct;
				s2 += c;
				
				i++;
			}
			
			s1 = s2;
			count++;
		}
		
		return s2;
	}
}
