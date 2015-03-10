package com.leetcode.jyang;

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid 
 * (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC032_LongestValidParentheses {

	public int longestValidParentheses(String s) {
		
		Stack<Character> st = new Stack<Character>();
		
		int maxLen = 0;
		int count=0;
		
		for (int i=0; i<s.length(); i++){
			
			char c = s.charAt(i);
			
			if (c=='('){
				st.push(c);
			}
			else {
				char p = 0;
				
				try {
					p = st.pop();
				}
				catch (Exception e){
					count=0;
				}
				
				if (p=='('){
					count++;	
				}
			}
			
			maxLen = Math.max(maxLen,  count);
		}
		
		return maxLen*2;
	        
	}
}
