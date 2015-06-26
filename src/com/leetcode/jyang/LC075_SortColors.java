package com.leetcode.jyang;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color
 * are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number
 * of 0's, then 1's and followed by 2's.
 *
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * 
 * @author jyang
 *
 */

public class LC075_SortColors {

    public void sortColors(int[] nums) {
        
    	if (nums==null || nums.length<=1)	return;
    	
    	int p1 = 0;
    	int p2 = nums.length - 1;
    	
   		for (int i=p1; i<=p2; i++){
   			
   			if (nums[i]==0){
   				swap(nums, i, p1);
   				p1++;
   			}
   			else if (nums[i]==2){
  				swap(nums, i, p2);
   				p2--;
   				i--;	// this is the whole trick, we need to re-process the 1's and 0's tossed 
   			}
   		}
    }
    
    private void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }
	
}
