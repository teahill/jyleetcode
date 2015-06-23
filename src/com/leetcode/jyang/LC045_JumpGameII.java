package com.leetcode.jyang;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then
 * 3 steps to the last index.)
 * 
 * 
 * @author jyang
 *
 */

public class LC045_JumpGameII {

    public int jump(int[] nums) {
    	
    	if (nums==null || nums.length==0)	return 0;
    	if (nums.length==1)		return 1;
    	
    	int jumps = 0;
    	int pos = 0;
    	
    	while (true){
    		
    		if (pos + nums[pos] >= nums.length-1){
    			jumps++;
    			return jumps;
    		}
    		
    		int farthest = 0;
    		
    		for (int i=pos+1; i<nums[pos]; i++){
    			if (i+nums[i] > farthest){
    				farthest = i+nums[i];
    				pos = i;
    			}
    		}
    		
    		jumps++;
    	}
        
    }
}
