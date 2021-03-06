package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, � , ak) must be in non-descending order. (ie, a1 � a2 � � � ak).
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

	public List<List<Integer>> combinationSum2(int[] candidates, int target){
		
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
		
		for (int i= start; i<candidates.length; i++){
			list.add(candidates[i]);
			combinationSumBT(candidates, target-candidates[i], i+1, list, res);
			list.remove(list.size()-1);
		}
	}
	
}
