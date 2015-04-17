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
 * Reference:
 * 
 * http://web.cse.ohio-state.edu/~gurari/course/cis680/cis680Ch19.html#QQ1-51-134
 * 
 * At each stage of the permutation process, the given set of elements consists of two parts: 
 * a subset of values that already have been processed, and a subset that still needs to be processed.
 * This logical separation can be physically realized by exchanging, in the i’th step, the i’th value
 * with the value being chosen at that stage. That approaches leaves the first subset in the first i
 * locations of the outcome.
 * 
 *  permute(i) 
 *  if i == N  output A[N] 
 *  else 
 *     for j = i to N do 
 *        swap(A[i], A[j]) 
 *        permute(i+1) 
 *        swap(A[i], A[j]) 
 * 
 *                                           a b c d
 *                                       /
 *        a b c d               b a c d                  c b a d              d b c a      
 *                         /       |      \
 *                 b a c d      b c a d     b d a c
 *                            /         \
 *                        b c a d     b c d a
 *                                       |
 *                                    b c d a
 *
 */

public class LC046_PermutationsShort {

	public List<List<Integer>> permute(int[] num) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		permuteBT(num, 0, res);
		
		return res;
	}
	
	private void permuteBT(int[] num, int start, List<List<Integer>> res){
		
		if (start==num.length-1){
			res.add(makeList(num));
		}
		else {
			for (int j=start; j<num.length; j++){
				swap(num, start, j);
				permuteBT(num, start+1, res);  // why it is start+1 instead of i+1?
				swap(num, start, j);
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
