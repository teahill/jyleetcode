package com.leetcode.jyang;

/**
 * This is one of the coding interview questions thrown at me.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class IQ001_ShortestRepeatingStr {

	public int findShortestPattern(String s){
		
		if (s==null || s.length()==0)	return 0;
		
		int slen = s.length(), len=1;
		
		while (len <= slen/2){			
			
			String pattern = s.substring(0, len);			
			
			if (slen%len==0){
				
				String tmp="";
				for (int i=0; i<slen/len; i++){
					tmp += pattern;
				}
				
				if (s.equals(tmp)){
					return pattern.length();
				}
			}

			len++;
		}
		
		return slen;
	}
	
}
