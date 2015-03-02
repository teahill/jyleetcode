package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * 
 * @author jyang
 *
 */

public class LC007_ReverseInteger {

	public int reverse(int x) {
		
		if (Math.abs((long)x) > Integer.MAX_VALUE){
		    return 0;
		}    
		
		if (Math.abs(x)<10) {
			return x;
		}
	        
		boolean isNegative = x < 0 ? true : false;
		
		int xx = Math.abs(x);
		
		List<Integer> digits = new ArrayList<Integer>();
		
		while (xx>0){			
			if (xx < 10){
				digits.add(xx);
			}
			else {
				int d = xx%10;
				digits.add(d);
			}
			
			xx = xx/10;
		}
		
		long factor = 1;
		long reversed = 0;
		
		for (int i=digits.size()-1; i>=0; i--){	
			reversed += digits.get(i) * factor;			
			factor *= 10;
		}
		
		if (isNegative) {
			reversed = -reversed;
		}
		
		if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE){
			reversed = 0;
		}
		
		return (int)reversed;
	}

	public static void main(String[] args) {
		
		int[] input = new int[] {
			5,
			-2,
			123,
			-123,
			120,
			2001,
			1534236469,
			-2147483648
			
		};
		
		LC007_ReverseInteger lc007 = new LC007_ReverseInteger();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Reversed of " + input[i] + " is " + lc007.reverse(input[i]));
		}
		
	}
	
}
