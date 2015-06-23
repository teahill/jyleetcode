package com.leetcode.jyang;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 * 
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * 
 * @author jyang
 * 
 * https://leetcode.com/discuss/14079/my-super-simple-solution-can-used-for-both-spiral-matrix-and
 */

public class LC059_SpiralMatrix {
	
    public int[][] generateMatrix(int n) {
    	
    	if (n<=0)	return new int[][]{};
    	if (n==1)	return new int[][]{{1}};
    	
    	int[][] res = new int[n][n];
    	
    	int count = 1;
    	int size = n * n;
    	int[] mode = new int[]{1};
    	
    	int[] pos = new int[]{0,0};
 
    	while (count <= size ) {
    		
    		res[pos[0]][pos[1]] = count;
    		count++;
    		
    		int[] nextPos = getNextPos(n, pos[0], pos[1], mode);
    		
    		pos[0] = nextPos[0];
    		pos[1] = nextPos[1];
    	}
    	
        return res;
    }
	
    private int[] getNextPos(int n, int i, int j, int[] mode){
    		
       	if (mode[0]%4==1){
       		j++;
    		if (j >= n - mode[0]/4 -1)	mode[0]++;
    	}
    	else if (mode[0]%4==2){
   			i++;
    		if (i >= n - mode[0]/4 -1)	mode[0]++;
    	}
    	else if (mode[0]%4==3){
    		j--;
    		if (j <= mode[0]/4)	mode[0]++;
    	}
    	else if (mode[0]%4==0){
   			i--;
    		if (i <= mode[0]/4)	mode[0]++;
    	}
       	
       	return new int[]{i,j};
    }
    
}