package com.leetcode.jyang;

/**
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 *
 * Note: The numbers can be arbitrarily large and are non-negative.
 * 
 * 
 * @author jyang
 *
 */

public class LC043_MultiplyStrings {

    public String multiply(String num1, String num2) {
    	
    	if (num1.equals("0") || num2.equals("0"))	return "0";
        
    	int rsize = num1.length() + num2.length();
    	int[] res = new int[rsize];
    	
    	for (int i=num1.length()-1; i>=0; i--){
    		for (int j=num2.length()-1; j>=0; j--){
    					
    			int prod = (num1.charAt(i)-48 )*(num2.charAt(j)-48);
    			
    			int tens = prod/10;
    			int ones = prod%10;
    			
    			int offset = num1.length()-1-i + num2.length()-1-j;
    			
    			res[rsize-1-offset] += ones;
    			res[rsize-1-offset-1] += tens;
    		}
    	}
    	
    	for (int k=rsize-1; k>0; k--){
    		if (res[k] >=10){
    			int tmp = res[k];
    			res[k] = tmp%10;
    			res[k-1] += tmp/10;
    		}
    	}
    	
    	int m;
    	for (m=0; m<rsize; m++){
    		if (res[m]!=0){
    			break;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int l=m; l<rsize; l++){
    			sb.append(res[l]);
    	}
    	
    	return sb.toString();
    }
	
}
