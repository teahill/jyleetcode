package com.leetcode.jyang;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 * 
 * 
 * @author jyang
 *
 */

public class LC029_DevideTwoIntegers {

    public int divide(int dividend, int divisor) {

        if(divisor == 1)
            return dividend;
        if(dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1)
            return Integer.MAX_VALUE;

        int sign = (dividend > 0 ^ divisor > 0) ? -1 : 1;

        long ans = 0;
        long end = Math.abs((long)dividend);
        long sor = Math.abs((long)divisor);

        
        while(end >= sor) {
        	
            long temp  = sor;
            long quotient = 1;
            
            // double the divisor until it is larger than the dividend, the quotient is recored
            while((temp << 1) < end) {
            	quotient <<= 1;
                temp  <<= 1;
            }
            ans += quotient;
            end -= temp; // do it again with updated dividend.
        }
        return (int)(sign * ans);
    }
	
}
