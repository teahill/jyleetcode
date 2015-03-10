package com.leetcode.jyang;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * 
 * @author jyang
 *
 */

public class LC066_PlusOne {
	
    public int[] plusOne(int[] digits) {
    	
    	int carry = 0;
    	int extra = 0;
    	
    	for (int i=digits.length-1; i>=0; i--){
 
    		if (i==digits.length-1){
    			extra = 1;
    		}
    		else {
    			extra = 0;
    		}
    		
       		int n = (digits[i]+carry+extra)%10;
    		carry = (digits[i]+carry+extra)/10;
    		
    		digits[i] = n;
    	}
    	
    	if (carry==0){
            return digits;
    	}
    	else {
    		int[] onePlus = new int[digits.length+1];
    		onePlus[0] = 1;
    		
    		for (int i=0; i<digits.length; i++){
    			onePlus[i+1] = digits[i];
    		}
    		
    		return onePlus;
    	}

    }

}
