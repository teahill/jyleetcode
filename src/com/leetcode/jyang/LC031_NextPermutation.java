package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, 
 * sorted in ascending order).
 * 
 * The replacement must be in-place, do not allocate extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are
 * in the right-hand column.
 * 
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * example: {1, 3, 1, 4, 2, 0} => {1, 3, 2, 0, 1, 4}
 * 
 * @author jyang
 * 
 * https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
 * 
 * The following algorithm generates the next permutation lexicographically after a given permutation.
 * It changes the given permutation in-place.
 * 
 * - Find the largest index k such that a[k] < a[k + 1]. If no such index exists, the permutation is the last permutation.
 * - Find the largest index l greater than k such that a[k] < a[l].
 * - Swap the value of a[k] with that of a[l].
 * - Reverse the sequence from a[k + 1] up to and including the final element a[n].
 *
 */

public class LC031_NextPermutation {

    public void nextPermutation(int[] nums) {
    	
    	if (nums==null || nums.length<=1){
    		return;
    	}
        
    	int k = -1;
    	
    	for (int i=nums.length-1; i>0; i--){
    		if (nums[i-1] < nums[i]){
    			k = i-1;
    			break;
    		}
    	}
    	
    	// already the last permutation
    	if (k==-1){
    		Arrays.sort(nums);
    		return;
    	}
    	
    	int l = k;
    	for (int j=nums.length-1; j>k; j--){
    		if (nums[k] < nums[j]){
    			l = j;
    			break;
    		}
    	}
    	
    	// swap k and j
    	swap(nums, k, l);
    	
    	// reverse k+1 to the end
    	int m = k+1;
    	int n = nums.length - 1;
    	
    	while (m < n){
    		swap(nums, m, n);
    		m++;
    		n--;
    	}
    }
	
    private void swap(int[] a, int i, int j){
    	int tmp = a[i];
    	a[i] = a[j];
    	a[j] = tmp;
    }
    
	public void nextPermutation(ArrayList<Integer> a) {
	    int n = a.size();
	    int index = -1;
	    
	    /* 
	        traverse the list from back and find the first occurance of 
	        element a[i] such that a[i] > a[i-1]. Store i-1 in index
	        eg. for a list a = {20, 10, 40, 48, 44, 34}, 40 is such an element. 
	        put index = 2 and break. 
	    */
	    for (int i = n-1; i > 0; i--) {
            if (a.get(i) > a.get(i-1)) {
                index = i-1;
                break;
            }
        }
        /*
            if such element does not exist, that means the list is in highest permutation. 
            return the list sorted in ascending order. 
        */
        if (index == -1) {
            Collections.sort(a);
        }
        else {
            /*
                find the successor element of a[index] in the traversed part of the
                list. Eg. for the given example list, look for an element which is successor 
                of 40 in the traversed part. a[index+1:n]. when found such element store
                the index in swapWithIndex. In this scenario swapWithIndex = 4 and the 
                element is 44.
            */
            int swapWithIndex = -1;
            for(int j = n-1; j >index; j--) {
                if (a.get(j) > a.get(index)) {
                    swapWithIndex = j;
                    break;
                }
            }
            /*
                swap elements a[index] with a[swapWithIndex]. 
                The list in scenario looks like this after this operation:
                a = {20, 10, 44, 48, 40, 34}
            */
            int temp = a.get(index);
            a.set(index, a.get(swapWithIndex));
            a.set(swapWithIndex, temp);
            /*
                sort the post index part of the list a[index+1:n] in ascending order.
                That means, in the example sort a[3:6] = {48, 40, 34}
            */
            Collections.sort(a.subList(index+1, n));
        }
	}
}
