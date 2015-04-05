package com.leetcode.jyang;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where
 *  the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, É , ak) must be in non-descending order. (ie, a1 ² a2 ² É ² ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC039_CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (candidates.length==0)	return res;
		
		Arrays.sort(candidates);
		
		int i;
		for (i=0; i<candidates.length; i++){
			if (candidates[i]>target)
				break;
		}
		
		if (i<candidates.length)
			candidates = Arrays.copyOf(candidates, i);
		
		List<Integer> list = new ArrayList<Integer>();
		
		combinationSumBT(candidates, target, 0, list, res);
		
		return res;
	}
	
	private void combinationSumBT(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> res){
		
		if (target<0)	return;
		
		if (target==0 && !res.contains(list)){
			res.add(new ArrayList<Integer>(list));
			return;
		}
		
		for (int i= start>0? start-1 : start; i<candidates.length; i++){
			list.add(candidates[i]);
			combinationSumBT(candidates, target-candidates[i], i+1, list, res);
			list.remove(list.size()-1);
		}
	}
	
}
