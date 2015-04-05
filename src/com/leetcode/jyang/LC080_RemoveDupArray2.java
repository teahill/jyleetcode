package com.leetcode.jyang;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 *
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 *
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * 
 * @author jyang
 * 
 * Notes:
 * 
 * The whole process can be thought as copying elements pointed by read index to slots pointed by
 * write index. This should always happen except for one case: the element to be copied already has
 * 2 instances in the copied elements, in which case we simply move the read index and hold on the 
 * write index.
 * 
 * See also Problem 26.
 *
 */

public class LC080_RemoveDupArray2 {
	
	public int removeDuplicates(int[] A) {
		
	    int p1 = 0;	// read index
	    int p2 = 0; // write index, p1>= p2

	    while(p1 < A.length) {
	    	
	        if (p1 < A.length && p2 < 2) {
	        	p2++;
	        }
	        // make sure the value we about to write, does not already have 2 values in a row already
	        //else if (A[p1] != A[p2 - 2] || A[p1] != A[p2-1])
	        else if (!(A[p1] == A[p2 - 2] && A[p1] == A[p2-1]))
	        {
	            A[p2] = A[p1];
	            p2++;
	        }
	        
	        p1++;
	    }

	    return p2;
	}
}
