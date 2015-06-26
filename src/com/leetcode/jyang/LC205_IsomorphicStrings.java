package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character but a character
 * may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 *
 * Given "foo", "bar", return false.
 *
 * Given "paper", "title", return true.
 * 
 * Given "ab", "aa", return false.
 *
 * Note:
 * You may assume both s and t have the same length.
 * 
 * 
 * @author jyang
 *
 */

public class LC205_IsomorphicStrings {
	
    public boolean isIsomorphic(String s, String t) {
    	
      	if (s==null || t==null)	return false;
    	if (s.isEmpty() || t.isEmpty())		return true;
    	
    	Map<Character, Character> map = new HashMap<Character, Character>();
    	
    	for (int i=0; i<s.length(); i++){
    		
    		char cs = s.charAt(i);
    		char ct = t.charAt(i);
    		
    		if (map.containsKey(cs)){
    			char c = map.get(cs);
    			if (c!=ct)	return false;
    		}
    		else {
    			if (map.containsValue(ct)){
    				return false;
    			}
        		map.put(cs,  ct);
    		}
    	}
        
    	return true;
    }

}
