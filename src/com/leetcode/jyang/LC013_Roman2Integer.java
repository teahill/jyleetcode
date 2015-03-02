package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * Level: Easy
 * 
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * @author jyang
 *
 */

public class LC013_Roman2Integer {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	
	static {
		map.put("I", 1);
		map.put("IV", 4);
		map.put("V", 5);
		map.put("IX", 9);
		map.put("X", 10);
		map.put("XL", 40);
		map.put("L", 50);
		map.put("XC", 90);
		map.put("C", 100);
		map.put("CD", 400);
		map.put("D", 500);
		map.put("CM", 900);
		map.put("M", 1000);
	}
	
    public int romanToInt(String s) {
    	
    	int n = 0;
        
    	for (int i=0; i<s.length();){
 
    		String key = String.valueOf(s.charAt(i));
    		
    		String next = "";
    		if (i <= s.length()-2){
    			next = String.valueOf(s.charAt(i+1));
    		}
    		
    		String key2 = key + next;
    		
    		Integer in = map.get(key2);
    		
    		if (in==null){
    			in = map.get(key);
    			i++;
    		}
    		else {
    			i += 2;;
    		}
    		
    		n += in;
    	}
    			
    	return n;
    }
}
