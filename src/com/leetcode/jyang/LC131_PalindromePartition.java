package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * For example, given s = "aab",
 * Return
 *
 * [
 *    ["aa","b"],
 *    ["a","a","b"]
 * ]
 *  
 * 
 * @author jyang
 *
 */

public class LC131_PalindromePartition {
	
    public List<List<String>> partition(String s) {
    	
    	List<List<String>> res = new ArrayList<List<String>>();
    	
    	if (s.length()==0){
    		return res;
    	}
 
    	return partitionBT(s);
    }
    
    public List<List<String>> partitionBT(String s) {
    	
    	List<List<String>> res = new ArrayList<List<String>>();
    	
    	if (s.isEmpty()){
    		return res;
    	}
    	
    	if (isPalindrome(s)){
   			List<String> tmp = new ArrayList<String>();
			tmp.add(s);
			res.add(tmp);
//			return res;
    	}
    	
    	for (int i=1; i<s.length(); i++){
    		
    		String left = s.substring(0, i);
    		
    		if (!isPalindrome(left)){
    			continue;
    		}
    		
    		String right = s.substring(i);
    		
    		List<List<String>> rRes = partitionBT(right);
    		
    		if (!rRes.isEmpty()){
    			for (List<String> l : rRes){
    				l.add(0, left);
    				res.add(l);
    			}
    		}
    	}
    	
    	return res;
    }

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
