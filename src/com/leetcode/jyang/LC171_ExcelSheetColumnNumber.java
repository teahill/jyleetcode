package com.leetcode.jyang;

/**
 * Related to question Excel Sheet Column Title
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *  A -> 1
 *  B -> 2
 *  C -> 3
 *  ...
 *  Z -> 26
 *  AA -> 27
 *  AB -> 28 
 * 
 * 
 * @author jyang
 *
 */

public class LC171_ExcelSheetColumnNumber {
	
    public int titleToNumber(String s) {
    	
    	if (s==null || s.isEmpty()){
    		return 0;
    	}
    	
    	int p = 0;
    	int n = 0;
        
    	for (int i=s.length()-1; i>=0; i--){
    		char c = s.charAt(i);
    		int d = (int)(c-64);
    		n += d*Math.pow(26, p);  		
    		p++;
    	}
    	
    	return n;
    }
}
