package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * @author jyang
 *
 */

public class LC071_SimplifyPath {

    public String simplifyPath(String path) {
        
   	if (path.equals("/") || path.equals("//")){
    		return path;
    	}
    	
   		
    	if (path.equals("/...") || path.equals("/.../")){
    		return "/...";
    	}
    	
    	boolean hasOnlyDotSlash = true;
    	for (int i = 0; i<path.length(); i++){
    		char c = path.charAt(i);
    		if (!(c=='.' || c=='/')){
    			hasOnlyDotSlash = false;
    		}
    	}
    	
    	if (hasOnlyDotSlash){
    		return "/";
    	}
    	
    	/* 
    	 * if a path starts with /, followed by any number of /'s, .'s or ..'s, we should all
    	 * return /, e.g.
    	 *   
    	 *   /..////.///..//..
         */
    	
    	StringTokenizer st = new StringTokenizer(path, "/");
    	
    	List<String> simplified = new ArrayList<String>();
    	
    	while (st.hasMoreTokens()){
    		
    		String t = st.nextToken();
    		
    		//System.out.println("->" + t + "<-");
    		
    		if (t.equals(".")){
    			continue;
    		}
    		else if (t.equals("..")){
    			if (simplified.isEmpty()){
    				simplified.add(t);
    			}
    			else {
    				simplified.remove(simplified.size()-1);
    			}
    		}
    		else {
    			simplified.add(t);
    		}
    	}
    	
    	if (simplified.isEmpty()){
    		return "/";
    	}
    	
    	String ret = "";
        
    	for (String s : simplified){
    		ret = ret + "/" + s;
    	}
    	
    	return ret;
    }
	
}
