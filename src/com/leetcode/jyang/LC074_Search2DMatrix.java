package com.leetcode.jyang;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * 
 * For example, consider the following matrix:
 * 
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 * 
 * 
 * @author jyang
 *
 * 12 13 14 16 18 20 23 25 
 * 27 30 33 34 35 37 38 40 
 * 41 43 45 48 50 52 53 54 
 * 55 57 58 60 63 66 69 70 
 * 71 73 76 78 81 83 86 87 
 * 
 * Target 43 exists? true
 *
 */

public class LC074_Search2DMatrix {

	// this is just a binary search in 2D
    public boolean searchMatrix(int[][] matrix, int target) {
    	
    	if (matrix==null || matrix.length==0) return false;
    	if (matrix[0].length==0)	return false;
    	
    	int row = -1;
    	int col = -1;
    	
       	// first try to find the right row
       	int low = 0, high = matrix.length - 1, mid;	
    	while (low <= high){
    		
    		mid = low + (high - low)/2;
    		
    		if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]){
    			row = mid;
    			break;
    		}
    		else if (matrix[mid][0] < target){
    			low = mid + 1;
    		}
    		else{
    			high = mid - 1;
    		}
    	}
    	if (row==-1) 	return false;
    	
    	// then try to find the right col position
    	low = 0; high = matrix[0].length - 1;	
    	while (low <= high){
    		
    		mid = low + (high - low)/2;
    		if (matrix[row][mid] > target){
    			high = mid - 1;
    		}
    		else if (matrix[row][mid] < target){
    			low = mid + 1;
    		}
    		else {
    			col = mid;
    			break;
    		}
    	}
    	
    	if (col==-1)	return false;
    	
        return true;
    }
    
    public boolean searchMatrixRef(int[][] matrix, int target) {
    	
    	for (int i=0; i<matrix.length; i++){
    		for (int j=0; j<matrix[0].length; j++){
    			if (matrix[i][j]==target){
    				return true;
    			}
    		}
    	}
    	
        return false;
    }
}
