package com.leetcode.jyang;

public class LC746_MinCostClimbingStaris {

    public int minCostClimbingStairs(int[] cost) {

        int[] save = new int[cost.length];
        
        save[0] = cost[0];
        save[1] = cost[1];

        for (int i = 2; i<cost.length; i++){
            save[i] = Math.min(save[i-1], save[i-2]) + cost[i];
        }
        
        return Math.min(save[cost.length-1], save[cost.length-2]);
    }
    
    public static void main(String[] args) {
    	
    	LC746_MinCostClimbingStaris lc746 = new LC746_MinCostClimbingStaris();
    	
    	//int[] cost = new int[] {10, 15, 20};
    	//int[] cost = new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
    	int[] cost = new int[] {0, 0, 1, 1};
    	
    	int res = lc746.minCostClimbingStairs(cost);
    	
    	System.out.println("res=" + res);
    }
	
}
