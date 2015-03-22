package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 *
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author jyang
 *
 */

public class LC140_WordBreak2 {

	Map<String, Boolean> map = new HashMap<String, Boolean>();
	
    public List<String> wordBreak(String s, Set<String> dict) {
        
    	List<String> res = new ArrayList<String>();
    	
    	String[] a = new String[dict.size()];
    	dict.toArray(a);
    	
    	if (s==null || s.isEmpty()){
    		return res;
    	}
    	
    	if (map.containsKey(s)){
    		return map.get(s);
    	}
    	
    	if (dict.contains(s)){
    		map.put(s, Boolean.valueOf(true));
    		return true;
    	}
    	    	
    	for (int i=0; i<a.length; i++){
    		
    		int start = s.indexOf(a[i]);
    		
    		if (start>=0){    			
    			boolean breakable = wordBreak(s.substring(0, start), dict) && wordBreak(s.substring(start + a[i].length(), s.length()), dict);
    			if (breakable){
    				map.put(s, Boolean.valueOf(true));
    				return true;
    			}
    			else {
    				map.put(s, Boolean.valueOf(false));
    			}
    		}
    	}
    	
    	return false;
    	
    }
	
}
