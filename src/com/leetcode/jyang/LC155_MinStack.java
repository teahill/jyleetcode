package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * 
 * @author jyang
 *
 */
public class LC155_MinStack {
	
	private Stack<Integer> mainSt = new Stack<Integer>();
	private Stack<Integer> minSt = new Stack<Integer>();
    
    public void push(int x) {
        mainSt.push(x);
        if (minSt.size() != 0) {
            int min = minSt.peek();
            if (x <= min) {
            	minSt.push(x);
            }
        } else {
        	minSt.push(x);
        }
    }

    public void pop() {
    	if (mainSt.isEmpty())	return;
    	
    	int x = mainSt.pop();
    	
    	if (minSt.size()>0){
	    	if (x==minSt.peek()){
	    		minSt.pop();
	    	}
    	}
    }

    public int top() {  
    	if (!mainSt.isEmpty())
    		return mainSt.peek();   	
    	else 
    		return Integer.MAX_VALUE;   	
    }

    public int getMin() {
    	if (!minSt.isEmpty())
    		return minSt.peek();   	
    	else 
    		return Integer.MAX_VALUE;
    }
}
