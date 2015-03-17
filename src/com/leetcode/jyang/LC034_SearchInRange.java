package com.leetcode.jyang;

/** 
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 */

public class LC034_SearchInRange {

    public int[] searchRange(int[] A, int target) {
    	
    	int[] r = new int[]{-1, -1};
    	
    	if (A==null || A.length==0){
    		return r;
    	}
    	
    	int low = 0;
    	int high = A.length-1;
    	
    	int mid = -1;

    	boolean found = false;
    	
    	while (low <= high){
    	
	    	mid  = low + (high-low)/2;
    		
    		if (target < A[mid]){
    			high = mid - 1;
    		}
    		else if (target > A[mid]){
    			low = mid + 1;
    		}
    		else {
    			found = true;
    			break;
    		}
    	}    	
    	
    	if (found){
	    	int i = mid;
	    	int j = mid;
	    	
	    	while (true){

	    		if (i-1 < 0){
	    			break;
	    		}
	    		
	    		if (A[i-1]!=target){
	    			break;
	    		}
	    		
	    		i--;
	    	}
	    	
	    	while (true){

	    		if (j+1 > A.length-1){
	    			break;
	    		}
	    		
	    		if (A[j+1]!=target){
	    			break;
	    		}
	    		
	    		j++;
	    	}
	    	
    		
    		r[0] = i;
    		r[1] = j;
    	}
    	
        return r;
    }
}
