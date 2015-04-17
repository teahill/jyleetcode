package com.leetcode.jyang;

import java.util.ArrayList;
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
        if(n == 0)
            return "";

        String res = "";

        // numbers to be added to result string
        List<Integer> num = new ArrayList<Integer>();

        // initialization, 0 just for padding
        for(int i = 0; i <= n; i++)
            num.add(i);

        int index;

        for(int i = n; i > 0; i--) {
            // calculate current number index
            index = (int)Math.ceil(k/(double)fact[i-1]);

            res += num.get(index);

            // after adding, delete it from rest set
            num.remove(index);

            // update k for the next loop
            k = k % fact[i-1];
            if(k == 0)
                k = fact[i-1];
        }
        return res;
}
	
	public String getPermutation2(int n, int k) {
		
		int[] num = new int[n+1];
		for (int i=1; i<=n; i++){
			num[i] = i;
		}
		
		int j;
		for (j=0; j<=n; j++){
			if (fact[j]>=k){
				break;
			}
		}
		
		List<Integer> picked = new ArrayList<Integer>();
		List<Integer> remain = new ArrayList<Integer>();
		
		for (int i=1; i<=n; i++){
			if (i<=n-j){
				picked.add(num[i]);
			}
			else {
				remain.add(num[i]);
			}			
		}
		
		if (picked.size()<n){
			getPermutationDP(n, k, picked, remain);
		}		
		
		String s="";
		
		for (Integer d : picked){
			s += d;
		}
		
		return s;
	}
	
	public void getPermutationDP(int n, int k, List<Integer> picked, List<Integer> remain){
		
		double q = (double)k/(double)fact[remain.size()];
		int i = (int) Math.ceil(q*remain.size())-1;
		int d = remain.get(i);
		
		picked.add(d);
		
		if (picked.size()==n){
			return;
		}

		remain.remove(i);
		
		k = k%fact[remain.size()];
		if (k==0){
			k = fact[remain.size()];
		}
		
		getPermutationDP(n, k, picked, remain);
	}
	
//	private int factorial(int n){
//		
//		if (n<=0)	return 0;
//		if (n==1)	return 1;
//		
//		int f = 1;
//		for (int i=1; i<=n; i++){
//			f = f*i;
//		}
//		
//		return f;
//	}
}
