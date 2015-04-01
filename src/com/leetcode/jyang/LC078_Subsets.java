package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * For example,
 * If S = [1,2,3], a solution is:
 *
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC078_Subsets {

    public List<List<Integer>> subsets(int[] S) {
    	
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(Collections.<Integer> emptyList());
		
		if (S.length==0){
			return res;
		}
	        
		if (S.length==1){
			res.add(Arrays.asList(new Integer[]{S[0]}));
			return res;
		}
		
		Arrays.sort(S);
		
		for (int i=0; i<S.length; i++){
			res.addAll(combine(S, i+1));
		}
		
		return res;
    }

    public List<List<Integer>> combine(int[] num, int k) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
        if(k>num.length)	{
        	return res;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
       	combineBT(list, 0, num, k, res);

        return res;
    }
    
    
    /* this is a brilliant back tracking algorithm, lightening fast :-)
     * for example, if input vector is 5, 3, the sequence of forming combinations is as:
     * 
     * list: 1, 2, 3 -> harvest
     * backtrack: 3 is removed
     * list: 1, 2, 4 -> harvest
     * backtrack: 4 is removed
     * list: 1, 2, 5 -> harvest
     * backtrack: 5 is removed
     * backtrack: 2 is removed
     * list: 1, 3, 4 -> harvest,
     * ...
     * 
     */
    public void combineBT(List<Integer> list, int start, int[] num, int k, List<List<Integer>>res){
        
    	if(k==0) {
    		// this is to harvest a valid combination
    		// note a new instance of array list is created out of list
            res.add(new ArrayList<Integer>(list));
            return;
        }
    	
    	/* code with typical backtracking pattern: 
    	 * 
    	 * Start Loop
    	 * 1. do something
    	 * 2. recursive call;
    	 * 3. undo step 1 
    	 * End Loop
    	 * 
    	 * Very similar pattern can be seen in Problem #46
    	 * 
    	 */
        for(int i=start; i<num.length; i++) {
            list.add(num[i]);
            combineBT(list, i+1, num, k-1, res);
            list.remove(list.size()-1);	// this is the backtracking part
        }
        
        return;
    }
}
