package com.leetcode.jyang;

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
 * Input:  9, 54494, output
 *
 *
 */

public class LC060_PermutationSeqMath {
	
	int[] fact = new int[]{1,1,2,6,24,120,720,5040,40320,362880};
	
	public String getPermutation(int n, int k) {
		
		//long t1 = System.currentTimeMillis();
		
		int[] res = new int[n+1];
		for (int i=1; i<=n; i++){
			res[i] = i;
		}
		
		int j;
		for (j=0; j<=n; j++){
			if (fact[j]>k){
				break;
			}
		}
		
		int s = n - j;
		
		getPermutationDP(n, k, s, res);
		
		return null;
	}
	
	public void getPermutationDP(int n, int k, int s, int[] res){
		
		// if we picked all the n digits, we are done
		if (s==n){
			return;
		}
		
		int d = getDigit(n, k, s, res);
		res[s+1] = d;
		
		getPermutationDP(n, k%factorial(n-s), s+1, res);
		
		//return getDigit(size, n, k) + getPermutationDP(size, n-1, k%factorial(n-1));	
	}
	
	/**
	 * 
	 * @param n: as in input
	 * @param k: as in input 
	 * @param s: end index of the partial solution array. If 2 digits are picked, s == 2.
	 * @param res: array of size n, holding the solution
	 * @return
	 */
	public int getDigit(int n, int k, int s, int[] res){
		
		double q = (double)k/(double)factorial(n-s);
		int i = (int) Math.ceil(q*(n-s)) + s;
		return res[i];
	}
	
	private int factorial(int n){
		
		if (n<=0)	return 0;
		if (n==1)	return 1;
		
		int prev = 1;
		for (int i=1; i<=n; i++){
			prev = prev*i;
		}
		
		return prev;
	}
	

}
