package com.leetcode.jyang;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author jyang
 * 
 *       ^
 * 0 1 2 4 5 6 7
 * 1 2 4 5 6 7 0
 * 2 4 5 6 7 0 1
 * 4 5 6 7 0 1 2
 * 5 6 7 0 1 2 4
 * 6 7 0 1 2 4 5
 * 7 0 1 2 4 5 6 
 *       ^
 */

public class LC153_FindMinRotatedArray {

    public int findMin(int[] nums) {
    	
    	if (nums==null || nums.length==0) return Integer.MIN_VALUE;
    	if (nums.length==1)		return nums[0];
    	
    	int lo=0, hi=nums.length-1, mid;
    	
    	while (lo <= hi){
    		
    		mid = lo + (hi - lo)/2;
    		
    		if (nums[mid] > nums[hi]) {	// minimum in right half
    			lo = mid + 1;
    		}
    		else if (nums[mid] < nums[lo]){ // minimum in left half
    			hi = mid;
    		}
    		else if (hi-lo <=2){
    			return Math.min(nums[lo], nums[hi]); // close enough
    		}
    		else {	// in order, no rotation
    			return nums[lo];
    		}
    	}
    	
    	return nums[0];
    }
}
