package com.leetcode.jyang;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of the squares of its digits, 
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in 
 * a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *  
 * Example: 19 is a happy number
 *
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * 
 * @author jyang
 *
 */

public class LC202_HappyNumber {

    public boolean isHappy(int n) {
        
    	if (n<=0)	return false;
    	Set<Integer> cycle = new HashSet<Integer>();
    	
    	while (true){
    		int next = getSquareSum(n);
    		//System.out.println("next=" + next);
    		if (next==1)	return true;
    		if (cycle.contains(next))	return false;
 	
    		cycle.add(next);		
    		n = next;
    	}
    	
    }
    
    private int getSquareSum(int n){
    	
    	int sum = 0;
    	
    	while (n>0){
    		int r = n%10;
    		n /= 10;
    		sum += (int)Math.pow(r, 2);
    	}
    	
    	return sum;
    	
    }
	
}
