package com.leetcode.jyang;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 *
 *
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * 
 * @author jyang
 * 
 * The trick is how to achieve using only constant memory. This can be done by using the first row and
 * column (or any row or column for that matter) to record if any columns and rows need to be set zero.
 * To do this we also need to figure out if the selected row and column itself needs to be set.
 *
 */

public class LC073_SetMatrixZeros {

    public void setZeroes(int[][] matrix) {
    	
    	if (matrix.length==0 || matrix[0].length==0)	return;
    	
    	boolean firstRowHasZero = false;
    	boolean firstColHasZero = false;
    	
    	// find out if the first row has zeros
    	for (int i=0; i<matrix[0].length; i++){
    		if (matrix[0][i]==0) {
    			firstRowHasZero = true;
    			break;
    		}
    	}
    	
    	// find out if the first col has zeros
    	for (int i=0; i<matrix.length; i++){
    		if (matrix[i][0]==0) {
    			firstColHasZero = true;
    			break;
    		}
    	}
    	
    	// looping through each element, and for each zero, mark the corresponding
    	// element in the first row and col.
    	for (int i=0; i<matrix.length; i++){
    		for (int j=0; j<matrix[0].length; j++){
    			if (matrix[i][j]==0){
    				matrix[0][j] = 0;
    				matrix[i][0] = 0;
    			}
    		}
    	}
    	
    	// going through first col and set all rows marked with having zeros
    	// leave the first row alone!
    	for (int i=1; i<matrix.length; i++){
    		if (matrix[i][0]==0) {
    			for (int k=1; k<matrix[0].length; k++){
    				matrix[i][k] = 0;
    			}
    		}
    	}
    	
       	// going through first row and set all cols marked with having zeros
    	// leave the first col alone!
    	for (int i=1; i<matrix[0].length; i++){
    		if (matrix[0][i]==0) {
    			for (int k=1; k<matrix.length; k++){
    				matrix[k][i] = 0;
    			}
    		}
    	}
    	
    	if (firstRowHasZero){
			for (int k=0; k<matrix[0].length; k++){
				matrix[0][k] = 0;
			}
    	}
    	
       	if (firstColHasZero){
    		for (int k=0; k<matrix.length; k++){
    			matrix[k][0] = 0;
    		}
       	}
    }
}
