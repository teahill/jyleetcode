package com.leetcode.jyang;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC067_AddBinary {

	public String addBinary(String a, String b) {
		
		String r = "";
		
		if (a==null || a.isEmpty()){
			return b;
		}
		else if (b==null || b.isEmpty()){
			return a;
		}
		
		int p1 = a.length() - 1;
		int p2 = b.length() - 1;
		
		int carry = 0;
		
		while (p1>=0 || p2>=0) {

			char ca = p1 >= 0 ? a.charAt(p1) : '0';
			char cb = p2 >= 0 ? b.charAt(p2) : '0';
			
			int ia = (int)(ca-48);
			int ib = (int)(cb-48);
			
			int sum = ia + ib + carry;
			
			carry = sum/2;		
			r = sum%2 + r;
	
			p1--;
			p2--;
		}
		
		if (carry>0){
			r = carry + r;
		}

		return r;
	}
	
}
