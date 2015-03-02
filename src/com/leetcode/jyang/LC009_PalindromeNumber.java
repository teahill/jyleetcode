package com.leetcode.jyang;

/**
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author jyang
 *
 */
public class LC009_PalindromeNumber {

    public boolean isPalindrome(int x) {
        
       	// stupid requirements from OJ - why sign matters here?
//    	if (x < 0){
//    		return false;
//    	}
    	
    	if (x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
    		return false;
    	}
    	
    	int n = Math.abs(x);
    	
    	int nDigits = 1;	
    	int q = n/10;
    	
    	while (q>0){
    		q /= 10;
    		nDigits++;	
    	}
    	
    	if (nDigits==1){
    		return true;
    	}
    	
    	// 10201, 321123
    	for (int i=1; i<=nDigits/2; i++) {
    		
    		int p1 = (int)Math.pow(10, (nDigits-i));
    		int p2 = (int)Math.pow(10, i);
    		int p3 = (int)Math.pow(10, i-1);
    		
    		int left = (n/p1)%10;
    		int right = (n%p2)/p3;
    		
    		//System.out.println("left=" + left + ", right=" + right);
    		
    		if (left!=right){
    			return false;
    		}
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {

		int[] input = new int[] {
			0,
			1,
			-2,
			212,
			1234,
			2002,
			-2002,
			-101010101,
			-2147483648,
			-2147447412
		};
		
		LC009_PalindromeNumber lc009 = new LC009_PalindromeNumber();
		
		for (int i=0; i<input.length; i++){
			System.out.println(input[i] + " is palindrome number? " + lc009.isPalindrome(input[i]));
		}
	}
}
