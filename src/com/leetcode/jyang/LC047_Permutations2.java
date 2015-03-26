package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

public class LC047_Permutations2 {

	public List<List<Integer>> permuteUnique(int[] num) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (num.length==0){
			return res;
		}
	        
		if (num.length==1){
			res.add(Arrays.asList(new Integer[]{num[0]}));
		}
		else {
			res = internal(num);
		}
		
		return res;
	}
	
	private List<List<Integer>> internal(int[] n){
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
		if (n.length==0){
			return res;
		}

		for (int i=0; i<n.length; i++){
			
			int anchor = n[i];
			
			int[] remain = partition(n, i);
			
			List<List<Integer>> rRes = internal(remain);
			
			if (rRes.isEmpty()){
				res.add(Arrays.asList(new Integer[]{anchor}));
			}
			else {
				for (List<Integer> r : rRes){					
					List<Integer> tmp = new ArrayList<Integer>();
					tmp.add(0, anchor);	
					tmp.addAll(r);
					if (!res.contains(tmp)){
						res.add(tmp);
					}
				}
			}
		}
		
		return res;
	}
	
	private int[] partition(int[] n, int pos){
		
		int[] r = new int[n.length-1];
		
		for (int i=0; i<n.length; i++){		
			if (i<pos){
				r[i] = n[i];
			}
			else if (i>pos){
				r[i-1] = n[i];
			}
		}
		
		return r;
	}
}
