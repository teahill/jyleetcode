package com.leetcode.jyang;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 * 
 * @author jyang
 *
 */

public class LC064_MinimumPathSum {
	
	public int minPathSum(int[][] grid) {
		
		if (grid.length==0 || grid[0].length==0){
			return 0;
		}
		
		int m = grid.length;
		int n = grid[0].length;  
		
		int[][] save = new int[m][n];
		
		save[0][0] = grid[0][0];
		
		for (int i=0; i<m; i++){
			for (int j=0; j<n; j++){
			
				if (i-1>=0 && j-1>=0){
					save[i][j] = grid[i][j] + Math.min(save[i][j-1], save[i-1][j]);
				}
				else if (i-1>=0){
					save[i][j] = grid[i][j] + save[i-1][j];
				}
				else if (j-1>=0){
					save[i][j] = grid[i][j] + save[i][j-1];
				}
				else {
					save[i][j] = grid[i][j];
				}
			}
		}
		
		return save[m-1][n-1];
		
		//return minPathSumNaive(grid, m-1, n-1);
	}

	public int minPathSumNaive(int[][] grid, int m, int n) {
		
		if (m<0 || n<0){
			return 0;
		}
		
		if (n-1>=0 && m-1>=0){
			return grid[m][n] + Math.min(minPathSumNaive(grid, m, n-1), minPathSumNaive(grid, m-1, n));
		}
		else if (n-1>=0){
			return grid[m][n] + minPathSumNaive(grid, m, n-1);
		}
		else if (m-1>=0){
			return grid[m][n] + minPathSumNaive(grid, m-1, n);
		}
		else {
			return grid[m][n];
		}
	}
}
