package com.leetcode.jyang;

/**
 * Rotate an array of n elements to the right by k steps.
 *
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * Related problem: Reverse Words in a String II
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC189_RotateArray {

    public void rotate(int[] nums, int k) {
    	
    	if (nums.length<=1){
    		return;
    	}
    	
    	k %= nums.length;
    	if (k==nums.length){
    		return;
    	}
    	
    	reverseArray(nums, 0, nums.length-k-1);
    	reverseArray(nums, nums.length-k, nums.length-1);
    	reverseArray(nums, 0, nums.length-1);
    }
	
    private void reverseArray(int num[], int start, int end){
    	
    	int i = start;
    	int j = end;
    	
    	while (i<j){
    		swap(num, i, j);
    		i++;
    		j--;
    	}    	
    }
    
    private void swap(int[] num, int a, int b){
    	int tmp = num[a];
    	num[a] = num[b];
    	num[b] = tmp;
    }
}
