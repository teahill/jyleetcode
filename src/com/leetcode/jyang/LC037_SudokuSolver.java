package com.leetcode.jyang;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 
 * A partially filled sudoku which is valid.
 * 
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells 
 * need to be validated.
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
 * 
 * @author jyang
 *
 */

public class LC037_SudokuSolver {
	
	public void solveSudoku(int[][] sudoku){
		
		solveSudokuBT(sudoku, 0, 0);
		
		LeetCodeUtils.printIntArray2D(sudoku);
	}
	
	public void solveSudokuBT(int[][] sudoku, int row, int col){
		
		if (row==9){
			return;
		}
		
		for (int i=row; i<9; i++){
			for (int j=col; j<9; j++){
				
				if (sudoku[i][j]!=0)	continue;
				
				for (int k=1; k<=9; k++){
					if (isValid(sudoku, i, j, k)){
						sudoku[i][j] = k;
						int[] pos = getNextPos(i, j); 
						solveSudokuBT(sudoku, pos[0], pos[1]);
						sudoku[i][j] = 0;
					}
				}
			}
		}
	}
	
	public int[] getNextPos(int i, int j){
		
		int[] pos = new int[2];
		
		if (j < 8) {
			pos[0] = i;
			pos[1] = j + 1;
		}
		else {
			pos[0] = i + 1;
			pos[1] = 0;
		}
		
		return pos;
	}
	
	public boolean isValid(int[][] sudoku, int row, int col, int value) {
		
		Set<Integer> rSet = new HashSet<Integer>();
		Set<Integer> cSet = new HashSet<Integer>();
		Set<Integer> sSet = new HashSet<Integer>();
		
		for (int i=0; i<9; i++){
			if (sudoku[row][i]!=0){
				rSet.add(sudoku[row][i]);
			}
		}		
		if (rSet.contains(value))	return false;
		
		for (int i=0; i<9; i++){
			if (sudoku[i][col]!=0){
				cSet.add(sudoku[i][col]);
			}
		}		
		if (cSet.contains(value))	return false;
		
		int x = row/3 * 3;
		int y = col/3 * 3;
		
		for (int i=0; i<3; i++){
			for (int j=0; j<3; j++){
				if (sudoku[x+i][y+j]!=0){
					sSet.add(sudoku[x+i][y+j]);
				}
			}
		}
		if (sSet.contains(value))	return false;
		
		return true;
	}
}
