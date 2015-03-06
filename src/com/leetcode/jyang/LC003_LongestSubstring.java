package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/** 
 * LEVEL: MEDIUM
 * 
 * Given a string, find the length of the longest substring without repeating characters. For example, 
 * the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * @author jyang
 *
 */

public class LC003_LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
    	
    	Map<Character, Integer> posMap = new HashMap<Character, Integer>();
    	
    	int start = 0;
    	int maxGap = 0;
    	
    	for (int i=0; i<s.length(); i++){
    		
    		char c = s.charAt(i);
    		
    		if (posMap.containsKey(c)){
    			start = Math.max(start, posMap.get(c)+1);
    		}
    		
    		posMap.put(c, i);
    		maxGap = Math.max(maxGap,  i-start+1);
    	}
    	
    	return maxGap;
    }
    
	public static void main(String[] args) {
		
		//String input = "abcabcbb";
		String input = "bbbbb";
		//String input ="aua";
		
		//String input = "abcadef";
		
		LC003_LongestSubstring lss = new LC003_LongestSubstring();
		
		int len = lss.lengthOfLongestSubstring(input);
		
		System.out.println("Longest sub string without repeating chars of " + input + " is " + len);
		
	}
}
