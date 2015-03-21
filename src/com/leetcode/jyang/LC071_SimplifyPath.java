package com.leetcode.jyang;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"
 * 
 * @author jyang
 *
 */

public class LC071_SimplifyPath {
	
	
	public String simplifyPath(String path) {
		
	   	StringTokenizer st = new StringTokenizer(path, "/");
    	Stack<String> stack = new Stack<String>();   	
    	
    	while (st.hasMoreTokens()){
    		
    		String t = st.nextToken();
    		
       		if (t.equals(".")){
    			continue;
    		}
    		else if (t.equals("..") && !stack.isEmpty()){    	
    			stack.pop();
    		}
    		else if (!t.equals("..")){
    			stack.push(t);
    		}
    	}
		
    	String ret = "";    
    	
    	while (!stack.isEmpty()){
    		String e = stack.pop();
    		ret = "/" + e + ret;
    	}
    	
    	return ret.isEmpty() ? "/" : ret;
	}
	
	public String simplifyPath_alt(String path){
		
	    Deque<String> stack = new LinkedList<String>();
	    
	    Set<String> skip = new HashSet<String>(Arrays.asList("..",".",""));
	    
	    for (String dir : path.split("/")) {
	        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
	        else if (!skip.contains(dir)) stack.push(dir);
	    }
	    
	    String res = "";
	    
	    for (String dir : stack) res = "/" + dir + res;
	    
	    return res.isEmpty() ? "/" : res;
		
	}
}
