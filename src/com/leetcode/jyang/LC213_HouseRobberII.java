package com.leetcode.jyang;

/**
 * After robbing those houses on that street, the thief has found himself a new place for his
 * thievery so that he will not get too much attention. This time, all houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, 
 * the security system for these houses remain the same as for those in the previous street.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * 
 * @author jyang
 * 
 * It seems 2 passes are needed to solve this problem.
 * 
 */

public class LC213_HouseRobberII {

    public int rob(int[] nums) {
    	
        int len = nums.length;
        if(len == 0) return 0;
        if(len == 1) return nums[0];
        
        int[] dp = new int[len];
        int useFirst, notUseFirst;
        
        //the first element used, so the last element can not be used
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        useFirst = dp[len-2];
        
        //the first element is not used, so the last element can be used
        dp[0] = 0;
        dp[1] = nums[1];
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        notUseFirst = dp[len-1];
        
        return Math.max(useFirst, notUseFirst);        
    }
	
}
