package com.leetcode.jyang;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * For example,
 * 
 * Given board =
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * 
 * @author jyang
 *
 */

public class LC079_WordSearch {

    public boolean exist(char[][] board, String word) {
    	
    	if (board.length==0 || board[0].length==0){
    		return false;
    	}
    	
    	if (word.isEmpty()){
    		return false;
    	}
    	
    	int m = board.length;
    	int n = board[0].length; 
    	
    	for (int i=0; i<m; i++){    		
    		for (int j=0; j<n; j++){
    			char c = board[i][j];
    			// found a seed
    			if (c==word.charAt(0)){
    				if (existInt(board, word, i, j)){
    					return true;
    				}
    			}
    		}    		
    	}
    	
    	return false;
    }  

    public boolean existInt(char[][] board, String word, int i, int j) {
    	
    	if (word.isEmpty()){
    		return true;
    	}
    	
    	if (word.charAt(0)!=board[i][j]){
    		return false;
    	}
    	   	
    	if (i+1<board.length){
    		if (existInt(board, word.substring(1), i+1, j))
    			return true;
    	}
    	
    	if (i-1>=0){
    		if (existInt(board, word.substring(1), i-1, j))
    			return true;
    	}
    	
    	if (j+1<board[0].length){
    		if (existInt(board, word.substring(1), i, j+1))
    			return true;
    	}
 
    	if (j-1>=0){
    		if (existInt(board, word.substring(1), i, j-1))
    			return true;
    	}
    	
    	return false;
    }
}
