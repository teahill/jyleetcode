package com.leetcode.jyang;

/**
 * 
 * mplement strStr().
 *
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of
 * haystack.
 *
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer. If you
 * still see your function signature returns a char * or String, please click the reload button to
 * reset your code definition.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC028_strStr {
	
    public int strStr(String haystack, String needle) {
    	
  	    if (haystack==null || needle==null) {
    		return -1;
    	}
    	
    	if(haystack.isEmpty() && needle.isEmpty()){
    	    return 0;
    	}
    	else if (needle.isEmpty()){
    		return 0;
    	}
    	else if (haystack.isEmpty()){
    		return -1;
    	}
    	
    	if (haystack.length() < needle.length()){
    		return -1;
    	}
    	
    	char n = needle.charAt(0);
    	
    	for (int i=0; i<=haystack.length() - needle.length(); i++){
    		
    		char c = haystack.charAt(i);
    		
    		if (c==n){
    	   		boolean found = true;
    			for (int j=0; j<needle.length(); j++){
    				if (haystack.charAt(i+j)!=needle.charAt(j)){
    					found = false;
    					break;
    				}
    			}
    			if (found){
    				return i;
    			}
    			else {
    				continue;
    			}
    		}
    	}
        return -1;
    }
}
