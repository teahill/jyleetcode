package com.leetcode.jyang;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise
 * return -1.
 *
 * You may assume no duplicate exists in the array.
 * 
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
 * 
 *
 */

public class LC033_SearchRotatedArray {
	
	public int search(int[] nums, int target) {
	    int lo = 0;
	    int hi = nums.length - 1;
	    
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (nums[mid] == target) return mid;

	        if (nums[lo] <= nums[mid]) {
	            if (target >= nums[lo] && target < nums[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > nums[mid] && target <= nums[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return nums[lo] == target ? lo : -1;
	}

}
