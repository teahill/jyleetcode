package com.leetcode.jyang;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * http://sudoku.com.au/TheRules.aspx
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be
 * validated.
 * 
 *     int[9][9] sudoko = new int[9][9] {
 *          {5,3,0,0,7,0,0,0,0},
 *          {6,0,0,1,9,5,0,0,0},
 *          {0,9,8,0,0,0,0,6,0},
 *          {8.0.0.0.6.0.0.0.3},
 *          {4,0,0,8,0,3,0,0,1},
 *          {7,0,0,0,2,0,0,0,6},
 *          {0,6,0,0,0,0,2,8,0},
 *          {0,0,0,4,1,9,0,0,5},
 *          {0,0,0,0,8,0,0,7,9}
 *     }
 * 
 * @author jyang
 *
 */

public class LC037_ValidSudoku {
	
	public boolean isValidSudoku(char[][] board) {
	    
		int size = board.length;
			
		Set[] rowSets = new HashSet[size];
		for (int i=0; i<size; i++){
			rowSets[i] = new HashSet();
		}
		Set[] colSets = new HashSet[size];
		for (int i=0; i<size; i++){
			colSets[i] = new HashSet();
		}
		Set[][] sqrSets = new HashSet[size/3][size/3];
		for (int i=0; i<size/3; i++){
			for (int j=0; j<size/3; j++){
				sqrSets[i][j] = new HashSet();
			}
		}
		
		for (int i=0; i<size; i++){
			for (int j=0; j<size; j++){
				
				char c = board[i][j];
				
				if (c=='0' || c=='.'){
					continue;
				}
				
				if (rowSets[i].contains(c) || colSets[j].contains(c) || sqrSets[i/3][j/3].contains(c)){
					return false;
				}
				else {
					rowSets[i].add(c);
					colSets[j].add(c);
					sqrSets[i/3][j/3].add(c);
				}	
			}
		}
		
		return true;
	}
	
}
