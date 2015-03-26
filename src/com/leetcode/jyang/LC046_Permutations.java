package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a collection of numbers, return all possible permutations.
 *
 * For example,
 * 
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * @author jyang
 *
 */

public class LC046_Permutations {

	public List<List<Integer>> permute(int[] num) {
		
	        
	}
	
	private List<List<String>> internal(int[] n){
		
		List<List<String>> res = new ArrayList<List<String>>();
		
		if (n.length==0){
			return res;
		}
		
		for (int i=0; i<n.length; i++){
			
			int anchor = n[i];
			
			int[] remain = partition(n, i);
			
			

			
		}
		
		
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
