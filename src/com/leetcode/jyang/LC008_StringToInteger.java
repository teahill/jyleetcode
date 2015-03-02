package com.leetcode.jyang;

public class LC008_StringToInteger {

    public int atoi(String str) {
    	
    	if (str==null || str.isEmpty()){
    		return 0;
    	}
    	
    	str = str.trim();
    	
    	boolean negative = false;
    	
    	if (str.startsWith("-")){
    		negative = true;
    		str = str.substring(1, str.length());
    	}
    	else if (str.startsWith("+")){
    		str = str.substring(1, str.length());
    	}
    	else {
    		;
    	}	
    	
   		int p;
    	for (p=0; p<str.length(); p++) {
    		char c = str.charAt(p);
    		if (c<48 || c>57) {
    			break;
    		}
    	}
    	
    	str = str.substring(0, p);
    	
    	if (str.length()>10) {
    		return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
    	}
    	
    	long factor = 1;
    	long n = 0;
    	
    	for (int i=str.length()-1; i>=0; i--) {
    		char c = str.charAt(i);
    		int d = (int)c - 48;
    		n += factor * d;
    		factor *= 10;
    	}
    	
    	if (negative){
    		n = -n;
    	}
    	
    	if (n > Integer.MAX_VALUE) {
    		return Integer.MAX_VALUE;
    	}
    	else if  (n < Integer.MIN_VALUE){
    		return Integer.MIN_VALUE;
    	}
    	else {
    		return (int)n;
    	} 
    }
    
	public static void main(String[] args) {
		
		String[] input = new String[] {
			"5",
			"-2",
			"123",
			"-123",
			"120",
			"2001",
			"1534236469",
			"6534236469",
			"85458490584958",
			"-2147483648",
			"-sifshfb%$^",
			"hdshfi936",
			"+2",
			"     010   ",
			"  -0012a42"
		};
		
		LC008_StringToInteger lc008 = new LC008_StringToInteger();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Converted of " + input[i] + " is " + lc008.atoi(input[i]));
		}
		
	}
	
}
