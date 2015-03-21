package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 * 
 * Above is a 3 x 7 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * 
 * @author jyang
 *
 */

public class LC062_UniquePaths {
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
	public int uniquePaths(int m, int n) {
    	
	   	if (m<=0 || n<=0){
    		return 0;
    	}
    	
    	if (m==1 || n==1){
    		return 1;
    	}
		
    	int[][] grid = new int[m][n];
    	
    	grid[0][0] = 1;
    	grid[1][0] = 1;
    	grid[0][1] = 1;
    	
    	for (int i=0; i<m; i++){
    		for (int j=0; j<n; j++){
    			
    			if (i-1>=0 && j-1>=0){
    				grid[i][j] = grid[i-1][j] + grid[i][j-1];
    			}
    			else if (i-1>=0){
    				grid[i][j] = grid[i-1][j];
    			}
       			else if (j-1>=0){
    				grid[i][j] = grid[i][j-1];
    			}
    		}
    	}
    	
    	return grid[m-1][n-1];
	}
	
    public int uniquePathsDP(int m, int n) {
    	
	   	if (m<=0 || n<=0){
    		return 0;
    	}
    	
    	if (m==1 || n==1){
    		return 1;
    	}
    	
    	String key = m + "-" + n;
    	
    	if (map.containsKey(key)){
    		return map.get(key);
    	}
    	
    	int uPath = uniquePathsDP(m-1, n) + uniquePathsDP(m, n-1);
    	map.put(key, uPath);
    	
    	return uPath;
    }
	
	
    public int uniquePathsNaive(int m, int n) {
    	
	   	if (m<=0 || n<=0){
    		return 0;
    	}
    	
    	if (m==1 || n==1){
    		return 1;
    	}
    	
    	return uniquePathsNaive(m-1, n) + uniquePathsNaive(m, n-1);
    }
}
