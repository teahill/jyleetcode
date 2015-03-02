package com.leetcode.jyang;

/**
 * Level: Easy
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:

 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 
 * @author jyang
 *
 */

public class LC006_ZigZag {

    public String convert(String s, int nRows) {
    	
    	if (s.isEmpty()){
    		return "";
    	}
    	
    	if (nRows==1){
    		return s;
    	}
    	
    	int nCols = s.length();
    		
    	char[][] matrix = new char[nRows][nCols];
    	
    	// going down or diagonal
    	
    	int row = 0;
    	int col = 0;
    	
    	matrix[row][col] = s.charAt(0);
    	
    	int steps = 0;
    	
    	boolean down = true;
    	
    	for (int i=1; i<s.length(); i++){
    		
    		if (down){
    			row++;
    		}
    		else {
    			row--;
    			col++;
    		}
    		
    		matrix[row][col] = s.charAt(i);
    		
    		printMatrix(matrix);
    		
    		steps++;
    		
    		if (steps >= nRows-1){
    			down = !down;
    			steps = 0;
    		}
    		
    	}
    	
    	String r = "";
    	
    	for (int j=0; j<nRows; j++){
    		for (int k=0; k<nCols; k++){
    			
    			if (matrix[j][k]!=0){
        			r += matrix[j][k];
    			}
    		}
    	}
    	
    	
    	return r;
    }
    
    public void printMatrix(char[][] matrix) {
    	
	   	for (int i=0; i<matrix.length; i++){
	   		
	   		for (int j=0; j<matrix[i].length; j++){
	   			System.out.print("[" + matrix[i][j] + "] ");
	   		}
	   		System.out.println();
	   	}
	   	
	   	System.out.println("\n\n");
    }
    
    public static void main(String[] args) {
    	
    	String input = "PAYPALISHIRING";
    	int n = 6;
    	
    	LC006_ZigZag lc006 = new LC006_ZigZag();
    	
    	System.out.println("Convert " + input + " into " + lc006.convert(input, n));
    	
    	
    }
	
}
