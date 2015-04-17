package com.leetcode.jyang;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 *
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC088_MergeSortedArray {

    public void merge(int A[], int m, int B[], int n) {
    	
    	if (A.length < m+n)	return;
    	     
    	int pw = m + n - 1;    	
    	int pa = m -1;
    	int pb = n -1;
    	
    	while (pw >= 0 && pa >=0 && pb >=0) {
    		
    		if (A[pa] > B[pb]){
    			A[pw] = A[pa];
    			pa--;
    		}
    		else if (A[pa] < B[pb]){
    			A[pw] = B[pb];
    			pb--;
    		}
    		else {
    			A[pw] = A[pa];
    			pa--;
    			pw--;
    			
    			A[pw] = B[pb];
    			pb--;
    		}
    		
    		pw--;
    	}
    	
    	if (pa < 0 && pb >=0) {
    		
    		for (int i=0; i<=pb; i++){
    			A[i] = B[i];
    		}
    		
    	}
    		
    }	
}
