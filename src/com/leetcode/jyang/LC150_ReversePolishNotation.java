package com.leetcode.jyang;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 * 
 * @author jyang
 *
 */

public class LC150_ReversePolishNotation {

    public int evalRPN(String[] tokens) {
    	
    	if (tokens==null || tokens.length==0){
    		return 0;
    	}
        
    	Stack<String> buf = new Stack<String>();
    	
    	for (String token : tokens){
    		
    		if (token.equals("+")){
    			String op2 = buf.pop();
    			String op1 = buf.pop();
    			
    			int tmp = Integer.valueOf(op1) + Integer.valueOf(op2);
    			buf.push(String.valueOf(tmp));
    		}
    		else if (token.equals("-")){
       			String op2 = buf.pop();
    			String op1 = buf.pop();
    			
    			int tmp = Integer.valueOf(op1) - Integer.valueOf(op2);
    			buf.push(String.valueOf(tmp));
    		}
       		else if (token.equals("*")){
       			String op2 = buf.pop();
    			String op1 = buf.pop();
    			
    			int tmp = Integer.valueOf(op1) * Integer.valueOf(op2);
    			buf.push(String.valueOf(tmp));
    		}
       		else if (token.equals("/")){
       			String op2 = buf.pop();
    			String op1 = buf.pop();
    			
    			int tmp = Integer.valueOf(op1) / Integer.valueOf(op2);
    			buf.push(String.valueOf(tmp));
    		}
       		else {
       			buf.push(token);
       		}
    	}
    	
    	String val = buf.pop();
    	
    	return Integer.valueOf(val);
    }
	
}
