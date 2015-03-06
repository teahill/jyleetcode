package com.leetcode.jyang;

import java.util.Stack;

/**
 * Level: Easy
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * 
 * @author jyang
 *
 */

public class LC020_ValidParentheses {

    public boolean isValid(String s) {
    	
    	if (s.length()%2!=0){
    		return false;
    	}
    	
    	Stack<Character> sk1 = new Stack<Character>();
    	
    	for (int i=0; i<s.length(); i++) {
    		
    		char c = s.charAt(i);
    		
    		if (c=='(' || c=='[' || c=='{'){
    			sk1.push(c);
    		}
    		else if (c==')' || c==']' || c=='}'){
    			
    			Character p = null;
    			
    			try {
    				p = sk1.pop();
    			}
    			catch (Exception e) {
    				;
    			}
    			
    			if (p==null){
    				return false;
    			}
    			
    			switch(c) {
	    			case ')':
	    				if (p!='('){
	    					return false;
	    				}
	    				break;
	       			case ']':
	    				if (p!='['){
	    					return false;
	    				}
	    				break;
	   				case '}':
					if (p!='{'){
						return false;
					}
					break;
					default:
						break;
	    		}
    			
    		}
    		else {
    			return false;
    		}
    	}
    	
        return sk1.isEmpty() ? true : false;
    }	
}
