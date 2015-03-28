package com.leetcode.jyang;

/**
 * You are given an n x n 2D matrix representing an image.
 *
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 * 
 * 
 *  A B C D E   U P K F A
 *  F G H I J   V Q L G B    
 *  K L M N O   W R M H C
 *  P Q R S T   X S N I D
 *  U V W X Y   Y T O J E
 * 
 * 
 * @author jyang
 * 
 * I guess the trick is that 4 pixels at a time? The rule to determine the new position after rotation for [i][j]:
 * 
 *  i = j;
 *  j = (size-1) - i;
 * 
 * 
 * Input:		[[1,2,3],[4,5,6],[7,8,9]]
 * Output	:	[[7,2,1],[4,5,6],[9,8,3]]
 * Expected:	[[7,4,1],[8,5,2],[9,6,3]]

 *
 */

public class LC048_RotateImage {

    public void rotate(int[][] matrix) {
        
    	int n = matrix.length;

    	if (matrix.length==0 || matrix[0].length==0)	return;
    	  	
    	for (int i=0; i<n/2; i++){
    		for (int j=0; j<=n/2; j++){
    			
    			int nexti = i;
    			int nextj = j;
    			
    			int prev = matrix[i][j];
    			
    			for (int k=0; k<4; k++){
    				   				
    				// get location for move target
    				int tmp = nexti;    				
    				nexti = nextj;
    				nextj = (n-1) - tmp;
    				   				
    				tmp = matrix[nexti][nextj];    				
    				matrix[nexti][nextj] = prev;
    				
    				prev = tmp;
    			}
    		}
    	}
    }
	
}
