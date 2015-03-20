package com.leetcode.jyang;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Solution: there are only 2 ways you can get to the top of n stairs:
 * 1. climb 1 step from n-1 stair, or
 * 2. climb 2 steps from n-2 stair;
 * 
 * Therefore d(n) = d(n-1) + d(n-2)
 * 
 * @author jyang
 *
 */

public class LC070_ClimbingStairs {
  
    public int climbStairs(int n){
    	
    	if (n==1){
    		return 1;
    	}
    	
    	if (n==2){
    		return 2;
    	}    	
    	
    	int[] save = new int[n+1];
    	save[1] = 1;
    	save[2] = 2;    	
    	
    	int i;
    	
    	for (i = 3; i < save.length; i++){    		
    		save[i] = save[i-1] + save[i-2];   		
    	}
    	
    	return save[n];
    }
    
    public int climbStairsRec(int n) {
        
    	if (n==1){
    		return 1;
    	}
    	
    	if (n==2){
    		return 2;
    	}
    	
    	return climbStairsRec(n-2) + climbStairsRec(n-1);
    }    
	
}
