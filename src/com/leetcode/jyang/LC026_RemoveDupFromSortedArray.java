package com.leetcode.jyang;

/**
 * Level: Easy
 * 
 * Remove the duplicated elements in place 
 * 
 * E.g. input A [1, 2, 2]
 * 
 * return length 2, and A is now [1, 2].
 * 
 * 
 * @author jyang
 *
 */

public class LC026_RemoveDupFromSortedArray {
	
	public int removeDuplicates(int[] A){
		
		int p1=1;
		int p2=1;
		
		int count = 0;

		while (p2<A.length && p1<A.length){

			while (p2<A.length && A[p2]==A[p2-1]){
				p2++;
				count++;
			}
			if (p2<A.length){
				A[p1]=A[p2];
			}
			
			p1++;
			p2++;
		}
		
		return A.length-count;
	}
	
	public int removeDuplicates2(int[] A){
		
		int count = 0;
		for(int i = 1; i < A.length; i++){
		    if(A[i] == A[i-1]) count++;
		    else A[i-count] = A[i];
		}
		return A.length-count;
	}
}
