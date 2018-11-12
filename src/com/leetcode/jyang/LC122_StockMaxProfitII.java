package com.leetcode.jyang;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as
 * you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC122_StockMaxProfitII {

    public int maxProfit(int[] prices) {
    	
       	if (prices==null || prices.length==0)
    		return 0;
    	
    	int maxProfit = 0;
    	int minSoFar = prices[0];
  	
    	for (int i=0; i<prices.length; i++){
    		
    		if (prices[i] > minSoFar){
    			maxProfit += prices[i] - minSoFar;
    		}
   			minSoFar = prices[i];
    	}
    	
        return maxProfit;      
    }
	
}
