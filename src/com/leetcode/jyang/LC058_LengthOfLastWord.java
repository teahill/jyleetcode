package com.leetcode.jyang;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * 
 * @author jyang
 *
 */

public class LC058_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        
    	if (s==null || s.isEmpty()){
    		return 0;
    	}
    	   	
    	int i = s.length()-1;
    	
    	while (i>=0 && s.charAt(i)==' '){
    		i--;
    	}

    	/* 
    	 * this caused test case "a" to fail!
    	if (i==0){
    		return 0;
    	}
    	*/
    	
    	int len = 0;
       	while (i>=0 && s.charAt(i)!=' '){
    		i--;
    		len++;
    	}
       	
       	return len;
    }
	
}
