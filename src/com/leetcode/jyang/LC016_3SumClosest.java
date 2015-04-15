package com.leetcode.jyang;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author jyang
 *
 */

public class LC016_3SumClosest {

    public int threeSumClosest(int[] num, int target) {
    	
    	int min = Integer.MAX_VALUE;
    	int res = num[0] + num[1] + num[2];
        
    	for (int i=0; i<num.length; i++){
    		for (int j=i+1; j<num.length; j++){
    			for (int k=j+1; k<num.length; k++){  
    				
    				int sum = num[i]+num[j]+num[k];
    				int diff = Math.abs(target - sum);
    				
    				if (diff==0)	return sum;
    				
    				if (diff < min){
    					min = diff;
    					res = sum;
    				}
    			}
    		}
    	}
    	
    	return res;
    }
	
}
