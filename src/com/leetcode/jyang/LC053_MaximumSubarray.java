package com.leetcode.jyang;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * 
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * 
 * 
 * @author jyang
 *
 */

public class LC053_MaximumSubarray {

    public int maxSubArray(int[] nums) {

		int maxSum = Integer.MIN_VALUE, sum = 0;
		
		for (int i=0; i<nums.length; i++){
			sum += nums[i];
			maxSum = Math.max(sum, maxSum);
			
			if (sum < 0)	sum=0;
		}
    	
    	return maxSum;
    }
	
}
