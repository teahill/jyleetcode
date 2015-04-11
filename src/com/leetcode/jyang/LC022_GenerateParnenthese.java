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
import java.util.Stack;

public class LC022_GenerateParnenthese {

	public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int n){

        if(str.length() == n*2){
            list.add(str);
            return;
        }

        if(open < n)
            backtrack(list, str+"(", open+1, close, n);
        if(close < open)
            backtrack(list, str+")", open, close+1, n);
    }

}
