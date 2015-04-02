package com.leetcode.jyang;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 *
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * 
 * @author jyang
 *
 */

public class LC191_NumberOfOneBits {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	
    	int s = 0;
    	
    	for (int i=0; i<32; i++){    		
    		int j = n&1;
    		s+= j;    		
    		n = n >> 1;
    	}
        
    	return s;
    }
	
}
