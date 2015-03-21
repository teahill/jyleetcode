package com.leetcode.jyang;

/**
 * 
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 *
 * Note: m and n will be at most 100.
 * 
 * @author jyang
 *
 */

public class LC063_UniquePaths2 {
    
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	   	
		if (obstacleGrid==null || obstacleGrid.length==0){
			return 0;
		}
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		
		if (m==1){
			for (int i=0; i<n; i++){
				if (obstacleGrid[0][i]==1){
					return 0;
				}
			}
			return 1;
		}
    	
		if (n==1){
			for (int i=0; i<m; i++){
				if (obstacleGrid[i][0]==1){
					return 0;
				}
			}
			return 1;
		}
		
    	int[][] grid = new int[m][n];
    	
    	grid[0][0] = 1;
    	grid[1][0] = 1;
    	grid[0][1] = 1;
    	
    	for (int i=0; i<m; i++){
    		for (int j=0; j<n; j++){
    			
    			if (obstacleGrid[i][j]==1){
    				grid[i][j] = 0;
    				continue;
    			}
    			
       			if (i-1>=0 && j-1>=0){
    				grid[i][j] = grid[i-1][j] + grid[i][j-1];
    			}
    			else if (i-1>=0){
    				grid[i][j] = grid[i-1][j];
    			}
       			else if (j-1>=0){
    				grid[i][j] = grid[i][j-1];
    			}
    			
//    			if (i-1>=0 && j-1>=0){ 				
//    				if (obstacleGrid[i-1][j]!=1){
//    					grid[i][j] += grid[i-1][j];
//    				}
//    				
//       				if (obstacleGrid[i][j-1]!=1){
//    					grid[i][j] += grid[i][j-1];
//    				}
//    			}
//    			else if (i-1>=0){
//       				if (obstacleGrid[i-1][j]!=1){
//    					grid[i][j] += grid[i-1][j];
//    				}
//    			}
//       			else if (j-1>=0){
//      				if (obstacleGrid[i][j-1]!=1){
//    					grid[i][j] += grid[i][j-1];
//    				}
//    			}
//       			else {
//       				grid[i][j] = 0;
//       			}
    		}
    	}
    	
    	return grid[m-1][n-1];
    }
}
