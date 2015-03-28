package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * The set [1,2,3,É,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 * 
 * @author jyang
 *
 */

public class LC060_PermutationSequence {
	
	public String getPermutation(int n, int k) {
		
		long t1 = System.currentTimeMillis();
		
		int[]num = new int[n];
		for (int i=0; i<n; i++){
			num[i] = i+1;
		}
		
		List<List<Integer>> res = permute(num);
		
		if (k>res.size())   return "";
		
		List<Integer> kth = res.get(k-1);
		
		String s = "";
		for (Integer m : kth){
			s += m;
		}
		
		long t2 = System.currentTimeMillis();
		
		System.out.println("Time used: " + (t2-t1));
		
		return s;     
	}

	public List<List<Integer>> permute(int[] num) {
		
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
					res.add(tmp);
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
