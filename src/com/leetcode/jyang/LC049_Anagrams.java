package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 * 
 * Example:
 *
 * Input: ["cat","rye","aye","dog", "god","cud","cat","old","fop","bra"]
 * 
 * Output: ["cat","cat","dog","god"]
 * 
 * @author jyang
 *
 */

public class LC049_Anagrams {

    public List<String> anagrams(String[] strs) {
    	
    	List<String> res = new ArrayList<String>();
    	Set<Integer> added = new HashSet<Integer>();
    	
    	if (strs==null || strs.length<=1)		return res;
    	
    	// key is hashcode, value is index
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i=0; i<strs.length; i++){
    		
    		int hashcode = getHashCode(strs[i]);    		
    		Integer prev = map.get(hashcode);
 
    		if (prev!=null){
    			
    			if (!added.contains(prev)){
    				res.add(strs[prev]);
    				added.add(prev);
    			}
    			
    			if (!added.contains(i)){
    				res.add(strs[i]);
    				added.add(i);
    			}
    		}
    		else {
    			map.put(hashcode, i);
    		}    		
    	}
    	
    	return res;
    }
	
    private int getHashCode(String s){
    	List<Character> list = new ArrayList<Character>();
    	for (int i=0; i<s.length(); i++){
    		list.add(s.charAt(i));
    	}
    	
    	Collections.sort(list);
    	return list.hashCode();
    }
}
