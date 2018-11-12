package com.leetcode.jyang;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 * share of the stock), design an algorithm to find the maximum profit.
 * 
 * 
 * @author jyang
 *
 */

public class LC121_StockMaxProfitI {

    public int maxProfit(int[] prices) {
    	
    	if (prices==null || prices.length==0)
    		return 0;
    	
    	int maxProfit = 0;
    	int minSoFar = prices[0];
  	
    	for (int i=0; i<prices.length; i++){
    		minSoFar = Math.min(minSoFar, prices[i]);		
    		maxProfit = Math.max(maxProfit, prices[i] - minSoFar);
    	}
    	
        return maxProfit;    
    }
	
}
