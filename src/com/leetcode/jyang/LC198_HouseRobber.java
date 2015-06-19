package com.leetcode.jyang;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a
 * certain amount of money stashed, the only constraint stopping you from robbing each of
 * them is that adjacent houses have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC198_HouseRobber {

	// 1,5,2,2,7,28,3,0,9,8,8
    public int rob(int[] nums) {

	   if(nums == null || nums.length == 0){
	       return 0;
	   }

	   if(nums.length == 1){
	       return nums[0];
	   }

	   if(nums.length == 2){
	       return Math.max(nums[0], nums[1]);
	   }


	   int[] dp = new int[nums.length];
	   dp[0] = nums[0];
	   dp[1] = Math.max(nums[0], nums[1]);

	   for(int i = 2; i < dp.length; i++){
	       dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
	   }

	   return dp[dp.length - 1];
    }
	
    public int rob2(int[] nums) {
    	
        int prevNo = 0;
        int prevYes = 0;
        
        // when looking at a number (house), say the third one (2), prevNo is the 
        // maximum so far if the previous one was not chosen, and prevYes is the 
        // maximum so far if the previous one was chosen.
        
        // how to update them in this case? now you need to stand on the position of 
        // the next one because you do this for the next round, in this case, the 4th
        // number. prevNo means the 3rd one is not chosen, therefore it is max(prevNo, prevYes),
        // prevYes means the the 3rd one (current n) is chosen, it should be the old prevNo plus
        // the current number (3rd).
        
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
    
}
