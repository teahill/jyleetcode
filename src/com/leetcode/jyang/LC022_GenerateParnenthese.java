package com.leetcode.jyang;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed 
 * parentheses.
 *
 * For example, given n = 3, a solution set is:
 * 
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * There are only 3 ways to generate the next combinations from the previous one:
 * 
 * - adding a pair () to the right
 * - adding a pair () to the left
 * - enclosing previous one with ()
 * 
 * n = 1: ()
 * n = 2: ()(), (())
 * n = 3: ()()(), ()(()), (())(), (()()), ((())) 
 * n = 4: (())(())
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC022_GenerateParnenthese {
	
	public List<String> generateParenthesis(int n) {
		
		if (n==0)	return Collections.emptyList();
		
		return GenerateParnentheseBT(n);
	}

	public List<String> GenerateParnentheseBT(int n){
		
		List<String> res = new ArrayList<String>();
		
		if (n==1){
			res.add("()");	
			return res;
		}
		
		List<String> prev = GenerateParnentheseBT(n-1);
		
		for (String s : prev){
			
			res.add("(" + s + ")");
			
			String tmp = "()" + s;
			if (!res.contains(tmp)){
				res.add(tmp);
			}
			
			tmp = s + "()";
			if (!res.contains(tmp)){
				res.add(tmp);
			}
		}
		
		return res;
	}
}
