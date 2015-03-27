package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given a collection of numbers that might contain duplicates, return all possible unique 
 * permutations.
 *
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * @author jyang
 *
 */

public class LC047_Permutations2Short {

	public List<List<Integer>> permuteUnique(int[] num) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permuteBT(num, 0, res);
		
		return res;
	}
	
	private void permuteBT(int[] num, int start, List<List<Integer>> res){
		
		Set<Integer> set = new HashSet<Integer>();
		
		if (start==num.length-1){
			List<Integer> tmp = makeList(num);
//			if (!res.contains(tmp)){
				res.add(makeList(num));
//			}
		}
		else {
			for (int j=start; j<num.length; j++){
				
				if (set.contains(num[j]))
					continue;

				swap(num, start, j);
				permuteBT(num, start+1, res);
				swap(num, start, j);
				
				set.add(num[j]);
			}
		}
	}
	
	private List<Integer> makeList(int[] num){
		List<Integer> tmp = new ArrayList<Integer>(num.length);
		for (int i=0; i<num.length; i++){
			tmp.add(num[i]);				
		}
		return tmp;
	}
	
	private void swap(int[] num, int i, int j){
		int tmp = num[i];
		num[i] = num[j];
		num[j] = tmp;
	}
}
