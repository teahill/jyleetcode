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
    	
        int prevNo = 0;
        int prevYes = 0;
        
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        
        return Math.max(prevNo, prevYes);
    }
}
