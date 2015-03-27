package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
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
		
		if (S.length==0){
			return res;
		}
	        
		if (S.length==1){
			res.add(Arrays.asList(new Integer[]{S[0]}));
		}
		else {
			res = internal(S);
		}
		
		return res;
        
    }

	private List<List<Integer>> internal(int[] n){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (n.length==0){
			return res;
		}

		for (int i=0; i<n.length; i++){
			
			
			
	
		}
		
		return res;
	}
}
