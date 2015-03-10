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
		
		StringBuilder sb = new StringBuilder();
		
		if (a==null || a.isEmpty()){
			return b;
		}
		else if (b==null || b.isEmpty()){
			return a;
		}
		
		int p1 = a.length() - 1;
		int p2 = b.length() - 1;
		
		while (p1>=0 || p2>=0) {

			char ca, cb;
			int carry = 0;
			
			if (p1 >= 0){
				ca = a.charAt(p1);
			}
			else {
				ca = '0';
			}
			
			if (p2 >= 0){
				cb = b.charAt(p2);
			}
			else {
				cb = '0';
			}
			
			int ia = (int)(ca-48);
			int ib = (int)(cb-48);
			
			int sum = ia + ib + carry;
			
			carry = sum/2;
			sb.append(sum%2);
			
			p1--;
			p2--;
		}

		return sb.toString();
	}
	
}
