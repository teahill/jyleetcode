package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * For example,
 * Given the following matrix:
 * 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * 10 11 12 13 
 * 14 15 16 17 
 * 18 19 20 21 
 * 22 23 24 25
 * 
 * 10 11 12 13 14 
 * 15 16 17 18 19 
 * 20 21 22 23 24 
 * 25 26 27 28 29 
 * 30 31 32 33 34 
 * 
 */

public class LC054_SprialMatrix {
	
	 public List<Integer> spiralOrder(int[][] matrix) {
		 
		 List<Integer> res = new ArrayList<Integer>();
		 
		 int row = matrix.length;
		 if (row==0)	return res;
		 
		 int col = matrix[0].length;
		 int size = row * col;
		 	 
		 int mode = col==1 ? 2 : 1;
		 int i=0, j=0;
		 
		 while (res.size() < size){
			 
			 if (i<row && j<col){ 
				 res.add(matrix[i][j]);
			 }
			 
			 if (mode%4==1)  { // right
				 j++;
				 if (j>=col-mode/4-1){
					 mode++;
				 }
			 }
			 else if (mode%4==2)  { // down
				 i++;
				 if (i>=row-mode/4-1){
					 mode++;
				 }
			 }
			 else if (mode%4==3)  { // left
				 j--;
				 if (j<=mode/4){
					 mode++;
				 }
			 }
			 else if (mode%4==0)  { // right
				 i--;
				 if (i<=mode/4){
					 mode++;
				 }
			 }
		 }

		 return res;
	 }

	// this solution mistakenly assumed that the matrix is n x n
    public List<Integer> spiralOrder2(int[][] matrix) {
    	
    	List<Integer> res = new ArrayList<Integer>();
    	int size = matrix.length;
    	int layers = size/2;
    	
    	for (int l=0; l<layers; l++){
    		
    		int i=l, j=l;
    		int mode = 0; // 0: right; 1: down; 2: left; 3: up
 
    		while (mode < 4) {
    			
    			res.add(matrix[i][j]);
    			
    			if (mode==0){
	    			j++;
	    			if (j==size-l-1)	mode++;
    			}
    			else if (mode==1){
	    			i++;
	    			if (i==size-l-1)	mode++;
    			}
    			else if (mode==2){
	    			j--;
	    			if (j==l)	mode++;
    			}
    			else {
	    			i--;
	    			if (i==l)	mode++;
    			}
    		}
    	}
    	
    	if (size%2==1){
    		res.add(matrix[size/2][size/2]);
    	}
        
    	return res;
    }
	
}
