package com.leetcode.jyang;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Math fact: #trailing_zeros_of_factorial_of_n = Sum(n/5^1, n/5^2, ..., n/5^m) where 5^m < n <5^(m+1).
 * 
 * Coding trick: use long, int is going to overflow. 
 * 
 * 
 * @author jyang
 *
 */

public class LC172_FactorialTrailingZeros {
	
    public int trailingZeroes(int n) {
    	
    	long e = 0;
    	long p = 0;
    	
    	do {
    		p = (long) Math.pow(5.0, (double)e);
    		e++;
    	} while (p < n);
    	
    	e = p==n ? e : e-1;
        
    	int sum = 0;
    	
    	for (int i=1; i<=e; i++){
    		long j = (long)n/(long)Math.pow((double)5.0, (double)i);
    		sum += j;
    	}
    	
    	return sum;
    }

}
