package com.leetcode.jyang;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, 
 * sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 * in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * example: {1, 3, 1, 4, 2, 0} => {1, 3, 2, 0, 1, 4}
 * 
 * @author jyang
 * 
 * https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 * 
 * The following algorithm generates the next permutation lexicographically after a given permutation.
 * It changes the given permutation in-place.
 * 
 * - Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 * - Find the largest index l greater than k such that a[k] < a[l].
 * - Swap the value of a[k] with that of a[l].
 * - Reverse the sequence from a[k + 1] up to and including the final element a[n].
 *
 */

public class LC031_NextPermutation {

    public void nextPermutation(int[] nums) {
    	
    	if (nums==null || nums.length<=1){
    		return;
    	}
        
    	int k = -1;
    	
    	for (int i=nums.length-1; i>0; i--){
    		if (nums[i-1] < nums[i]){
    			k = i-1;
    			break;
    		}
    	}
    	
    	// already the last permutation
    	if (k==-1){
    		Arrays.sort(nums);
    		return;
    	}
    	
    	int l = k;
    	for (int j=nums.length-1; j>k; j--){
    		if (nums[k] < nums[j]){
    			l = j;
    			break;
    		}
    	}
    	
    	// swap k and j
    	swap(nums, k, l);
    	
    	// reverse k+1 to the end
    	int m = k+1;
    	int n = nums.length - 1;
    	
    	while (m < n){
    		swap(nums, m, n);
    		m++;
    		n--;
    	}
    }
	
    private void swap(int[] a, int i, int j){
    	int tmp = a[i];
    	a[i] = a[j];
    	a[j] = tmp;
    }
}
