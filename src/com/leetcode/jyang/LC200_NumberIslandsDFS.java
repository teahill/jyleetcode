package com.leetcode.jyang;

/**
 * 
 * https://leetcode.com/problems/number-of-islands/
 * 
 * @author jyang
 *
 */

public class LC200_NumberIslandsDFS {

    public int numIslands(char[][] grid) {
        
        if (grid==null || grid.length==0 || grid[0].length==0) {
        	return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i<grid.length; i++) {
        	for (int j=0; j<grid[0].length; j++) {
        		if (grid[i][j]=='1') {
        			visit(grid, i, j);
        			count++;
        		}
        	}
        }
        
        return count;
    }
	
    private void visit(char[][] grid, int i, int j) {
    	
//    	if (grid[i][j]=='0') {
//    		return;
//    	}
    	
    	grid[i][j] = '0';
    	
    	// up neighbor
    	if (i-1>=0 && grid[i-1][j]=='1') {
    		visit(grid, i-1, j);
    	}
    	// down
    	if (i+1<=grid.length-1 && grid[i+1][j]=='1') {
    		visit(grid, i+1, j);
    	}
    	// left
    	if (j-1>=0 && grid[i][j-1]=='1') {
    		visit(grid, i, j-1);
    	}
    	// right
    	if (j+1<=grid[0].length-1 && grid[i][j+1]=='1') {
    		visit(grid, i, j+1);
    	}
    }
}
