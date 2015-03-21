package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words. 
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"]. 
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC139_WordBreak {
	
	Map<String, Boolean> map = new HashMap<String, Boolean>();
	
    public boolean wordBreak(String s, Set<String> dict) {
        
    	String[] a = new String[dict.size()];
    	
    	dict.toArray(a);
    	
    	if (s==null || s.isEmpty()){
    		return true;
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
