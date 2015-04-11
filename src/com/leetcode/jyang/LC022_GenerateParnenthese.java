package com.leetcode.jyang;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed 
 * parentheses.
 *
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * There are only 3 ways to generate the next combinations from the previous one:
 * 
 * - adding a pair () to the right
 * - adding a pair () to the left
 * - enclosing previous one with ()
 * 
 * n = 1: ()
 * n = 2: ()(), (())
 * n = 3: ()()(), ()(()), (())(), (()()), ((())) 
 * n = 4: (())(())
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LC022_GenerateParnenthese {
	
	public List<String> generateParenthesis(int n) {
		
		if (n==0)	return Collections.emptyList();
		
		char[] buf = new char[2*n];
		
		for (int i=0; i<2*n; i++){
			if (i<n){
				buf[i] = '(';
			}
			else {
				buf[i] = ')';
			}
		}

		List<String> res = new ArrayList<String>();
		
		GenerateParnentheseBT(res, buf, 0);
		
		return res;
		
		//return this.GenerateParnentheseRec(n);
	}

	public void GenerateParnentheseBT(List<String> res, char[] buf, int start){
		
		if (start==buf.length-1){
			
			if (isValid(buf)){
				String t = buildString(buf);
				if (!res.contains(t)){
					res.add(t);
				}
			}
		}
			
		for (int i=start; i<buf.length; i++){
			swap(buf, i, start);
			GenerateParnentheseBT(res, buf, start+1);
			swap(buf, i, start);
		}
	}
	
	private String buildString(char[] buf){
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<buf.length; i++){
			sb.append(buf[i]);
		}
		
		return sb.toString();	
	}
	
	private void swap(char[] buf, int i, int j){
		char tmp = buf[i];
		buf[i] = buf[j];
		buf[j] = tmp;
	}
	
	public List<String> GenerateParnentheseRec(int n){
		
		List<String> res = new ArrayList<String>();
		
		if (n==1){
			res.add("()");	
			return res;
		}
		
		List<String> prev = GenerateParnentheseRec(n-1);
		
		for (String s : prev){
			
			res.add("(" + s + ")");
			
			String tmp = "()" + s;
			if (!res.contains(tmp)){
				res.add(tmp);
			}
			
			tmp = s + "()";
			if (!res.contains(tmp)){
				res.add(tmp);
			}
		}
		
		return res;
	}
	
	public boolean isValid(char[] s) {
    	
    	if (s.length%2!=0){
    		return false;
    	}
    	
    	Stack<Character> sk1 = new Stack<Character>();
    	
    	for (int i=0; i<s.length; i++) {
    		
    		char c = s[i];
    		
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
