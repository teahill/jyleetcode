package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two
 * queens attack each other.
 * 
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * 
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * 
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 *  ]
 * 
 * 
 * @author jyang
 *
 */

public class LC052_NQueensII {
		
	private static int c = 0;
	
    public int totalNQueens(int n) {
    	
    	if (n<=0 || n==2 || n==3)	return 0;
    	if (n==1)	return 1;
    	
    	List<int[]> queens = new ArrayList<int[]>();
    	int[][] grid = new int[n][n];
    	
    	placeQueen(0, n, grid, queens);
    	return c;
    } 
    
    private void placeQueen(int col, int n, int[][] grid, List<int[]> queens){
    	
    	if (col==n){
    		c++;
    		return;
    	}
    		
    	for (int i=0; i<n; i++){
    		
    		if (grid[i][col]==0){

    			int[] qp = new int[]{i, col};
    			queens.add(qp);
    			
    	   		markAllAttackPos(queens, grid);
    	   		placeQueen(col+1, n, grid, queens);
    	   		
    	   		// backtrack, reset the grid and re-mark the grid
    	   		queens.remove(queens.size()-1);
    	   		grid = new int[n][n];
    	   		markAllAttackPos(queens, grid);
    		}
    	}
    }
    
    private void markAllAttackPos(List<int[]> queens, int[][] grid){
    	
    	for (int[] queen : queens){
    		markAttackPos(queen[0], queen[1], grid);
    	}
    }
    
    private void markAttackPos(int i, int j, int[][] grid){
    	
    	int m, n;
    	
    	for (n = 0; n < grid[i].length; n++){
    		grid[i][n] = 1;
    	}
    	
//       	for (m = 0; m < grid.length; m++){
//    		grid[m][j] = 1;
//    	}
       	
       	for (m = i, n = j; m < grid.length && n < grid[i].length; m++, n++){
       		grid[m][n] = 1;
       	}
    	
      	for (m = i, n = j; m >= 0 && n >= 0; m--, n--){
       		grid[m][n] = 1;
       	}
      	
     	for (m = i, n = j; m >= 0 && n < grid.length; m--, n++){
       		grid[m][n] = 1;
       	}
     	
     	for (m = i, n = j; m < grid.length && n >=0; m++, n--){
       		grid[m][n] = 1;
       	}
    }
}
