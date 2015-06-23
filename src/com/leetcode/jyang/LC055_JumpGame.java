package com.leetcode.jyang;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Determine if you are able to reach the last index.
 *
 * For example:
 * A = [2,3,1,1,4], return true.
 * 
 * A = [3,2,1,0,4], return false.
 * 
 * 
 * 
 * @author jyang
 *
 * https://leetcode.com/discuss/28252/accepted-java-solution-with-explanation
 *
 */

public class LC055_JumpGame {
	
    public boolean canJump(int[] nums) {
    	
    	int farthest = 0;
    	
    	if (nums.length==0)		return false;
    	if (nums.length==1)		return true;
        
    	for (int i=0; i<nums.length-1; i++){  		
    		if (farthest < i)	return false;
    		farthest = Math.max(farthest, i + nums[i]);
    	}
    	
    	return farthest >= nums.length - 1;
    }
    
    public boolean canJump2(int[] nums) {
    	
        if(nums.length == 0){
            return false;
        }

        if(nums.length == 1){
            return true;
        }

        int last = nums.length - 1;
        int jump = 0;

        for(int i = 0; i < last; i++){
            if(nums[i] == 0){
                for(int j = i - 1; j >= 0; j--){                  
                    jump = Math.max(jump,nums[j]+j);
                }
                if(jump <= i){
                    return false;
                }
            }
        }

        return true;        
    }

	// naive implementation caused TLE
    public boolean canJump3(int[] nums) {
    	
    	if (nums.length==0)		return false;
    	if (nums.length==1)		return true;
        
    	boolean[] jump = new boolean[nums.length];
    	jump[0] = true;
    	
    	for (int i=0; i<nums.length; i++){
    		for (int j=1; j<=nums[i]; j++){
    			if (i+j<nums.length){
    				jump[i+j] = true;
    			}
    		}
    	}
    	
    	for (int k=0; k<nums.length; k++){
    		if (jump[k]==false)
    			return false;
    	}
    	
    	return true;
    }
	
}
