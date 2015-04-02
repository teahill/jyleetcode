package com.leetcode.jyang;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 *
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * Related problem: Reverse Integer
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 * 
 * @author jyang
 *
 */

public class LC190_ReverseBits {
	
    public int reverseBits(int n) {
    	
        long sum=0;
        
        for(int i=0;i<32;i++){
            sum += Math.pow(2,31-i)*(n&1);
            n = n>>1;
        }
        
        return (int)sum;       
    }

    // you need treat n as an unsigned value
    public long reverseBits(long n) {

    	String s = "";	
    	long r = 0;
    	
    	do {
    		r = n%2;
    		s = r + s;
    		
    		n = n/2;
    	} while (n>0);
    	
    	long l = 0;
    	
    	for (int i=s.length()-1, j=31; i>=0 && j>=0; i--, j--){
    		char c = s.charAt(i);
    		if (c=='0')	continue;
    		l += Math.pow(2, j);
    	}
    	
//    	if (l>Integer.MAX_VALUE){
//    		
//    	}

    	return l;
    }
	
}
