package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * 
 * 
 * @author jyang
 *
 */
public class LC040_CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] num, int target) {
		
		List<List<Integer>> tmp = new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (num.length==0) return res;
		
		Arrays.sort(num);
		
		tmp.add(new ArrayList<Integer>());
		tmp.add(new ArrayList<Integer>());
		tmp.get(1).add(num[0]);
		
		if (num[0]==target){
			res.add(tmp.get(1));
		}
		
		int prev = 1;
		
		for (int i=1; i<num.length; i++){
			
			int size = tmp.size();
	        if (num[i]!=num[i-1])   // if different
	            prev = size;        // this means add num[i] to all lists in res;
			
			for (int j=size-prev; j<size; j++){
				
				List<Integer> list = tmp.get(j);
				
				List<Integer> a = new ArrayList<Integer>(list);
				a.add(num[i]);
				tmp.add(a);
				
				if (target == getElementSum(a)){
					res.add(a);
				}
			}
		}
		
	    return res;
	}
	
	private int getElementSum(List<Integer> list){	
		int sum = 0;
		for (Integer i : list){
			sum += i;
		}
		return sum;
	}
	
}
