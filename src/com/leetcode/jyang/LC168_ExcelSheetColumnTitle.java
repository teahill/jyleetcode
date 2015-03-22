package com.leetcode.jyang;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *   1 -> A
 *   2 -> B
 *   3 -> C
 *   ...
 *   26 -> Z
 *   27 -> AA
 *   28 -> AB 
 * 
 * 
 * @author jyang
 *
 */

public class LC168_ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
    	
    	String s = "";
    	
    	while (n>0){
    		n--;
    		s = (char)((n%26)+65) + s;
    		n/=26;
    	}
  
    	return s;
    }

}
