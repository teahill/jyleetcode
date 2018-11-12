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

	
	// Returns index of key in arr[l..h]  
    // if key is present, otherwise returns -1 
    static int search(int arr[], int l, int h, int key) 
    { 
        if (l > h)  
            return -1; 
        
        int mid = (l+h)/2; 
        if (arr[mid] == key) 
            return mid; 
        
        /* If arr[l...mid] is sorted */
        if (arr[l] <= arr[mid]) 
        { 
            /* As this subarray is sorted, we  
               can quickly check if key lies in  
               half or other half */
            if (key >= arr[l] && key <= arr[mid]) 
               return search(arr, l, mid-1, key); 
        
            return search(arr, mid+1, h, key); 
        } 
        
        /* If arr[l..mid] is not sorted,  
           then arr[mid... r] must be sorted*/
        if (key >= arr[mid] && key <= arr[h]) 
            return search(arr, mid+1, h, key); 
        
        return search(arr, l, mid-1, key); 
    } 
}
