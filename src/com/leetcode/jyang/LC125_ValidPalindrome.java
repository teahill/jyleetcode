package com.leetcode.jyang;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring
 * cases.
 *
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * @author jyang
 *
 */

public class LC125_ValidPalindrome {

    public boolean isPalindrome(String s) {
    	
    	if (s==null || s.isEmpty()){
    		return true;
    	}
    	
    	s = s.toLowerCase();
    	
    	int i = 0;
    	int j = s.length() - 1;
    	
    	while (i<=j){
    		
    		char ci = s.charAt(i);
    		char cj = s.charAt(j);
    		
    		if (!Character.isLetterOrDigit(ci)){
    			i++;
    			continue;
    		}
    		
       		if (!Character.isLetterOrDigit(cj)){
    			j--;
    			continue;
    		}
       		
       		if (ci!=cj){
       			return false;
       		}
       		
       		i++;
       		j--;
    	}
    	
    	return true;
    }
	
}
