package com.leetcode.jyang;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were
 * inserted in order.
 *
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * 
 * [1,3,5,6], 5 -> 2
 * [1,3,5,6], 2 -> 1
 * [1,3,5,6], 7 -> 4
 * [1,3,5,6], 0 -> 0
 * 
 * @author jyang
 *
 */

public class LC035_SearchInsertPos {

    public int searchInsert(int[] A, int target) {
    	
    	if (A == null || A.length==0){
    		return 0;
    	}
    	
    	if (target < A[0]) {
    		return 0;
    	}
    	
    	if (target > A[A.length-1]){
    		return A.length;
    	}
    	
    	int low = 0;
    	int high = A.length-1;
    	
    	int mid = -1;
    	
    	while (low <= high){
    	
	    	mid  = low + (high-low)/2;
    		
    		if (target < A[mid]){
    			high = mid - 1;
    		}
    		else if (target > A[mid]){
    			low = mid + 1;
    		}
    		else {
    			return mid; 
    		}
    	}    	
    	
    	System.out.println("A[" + mid + "] is " + A[mid]);
    	
    	return target > A[mid] ? mid+1 : mid;    	   	
    }
	
}
