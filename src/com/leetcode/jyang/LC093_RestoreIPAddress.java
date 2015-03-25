package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * Tricky test case: given "010010", return [0.10.0.10 0.100.1.0] (no elimination of any digits allowed, and no leading zeros)
 * 
 * @author jyang
 *
 */

public class LC093_RestoreIPAddress {

    public List<String> restoreIpAddresses(String s) {
    	
    	List<String> res = new ArrayList<String>();
    	
    	if (s==null || s.length()<4 || s.length()>12){
    		return res;
    	}
    	    	
    	for (String str : internal(s)){
    		if (str.split("\\.").length==4){
    			res.add(str);
    		}
    	}
    	
    	return res;
    }
    
    public List<String> internal(String s){
    	
    	List<String> res = new ArrayList<String>();
    	
    	if (s.isEmpty()){
    		return res;
    	}
    	
    	// three choices: 1-digit, 2-digit, 3-digit segments
    	for (int i=1; i<=3 && i<=s.length(); i++){
    		
    		String seg = s.substring(0, i);
    		
    		if (!isValidIPSegment(seg)){
    			continue;
    		}
  
			List<String> rRes = internal(s.substring(i));
			
			if (rRes.isEmpty()){
				res.add(seg);
			}
			else {
	   			for (String r : rRes){    	   				
 	   				String[] tmp = r.split("\\.");
	   				if (tmp.length<=3){
	   					res.add(seg + "." + r);
	   					res.remove(seg);
	   				}
    			}	
			}
    	}
    	
    	return res;
    }
    
    boolean isValidIPSegment(String seg){
    	
    	if (seg.length()==2 && seg.charAt(0)=='0'){
    		return false;
    	}
    	else if (seg.length()==3 && (seg.startsWith("00") || seg.startsWith("0"))){
    		return false;
    	}
    	else {
    		return Integer.valueOf(seg) > 255 ? false : true;
    	}
    }
}
