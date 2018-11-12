package com.leetcode.jyang;

import java.util.LinkedList;
import java.util.Queue;

public class LC200_NumberIslandsBFS {
	
    public int numIslands(char[][] grid) {
        
        if (grid==null || grid.length==0 || grid[0].length==0) {
        	return 0;
        }
        
        int count = 0;
        
        for (int i = 0; i<grid.length; i++) {
        	for (int j=0; j<grid[0].length; j++) {
        		if (grid[i][j]=='1') {
        			search(grid, i, j);
        			count++;
        		}
        	}
        }
        
        return count;
    }

    private void search(char[][] grid, int i, int j) {
    	
    	Queue<Pos> queue = new LinkedList<Pos>();
    	
    	queue.add(new Pos(i,j));
    	
    	while (!queue.isEmpty()) {
    		
    		Pos p = queue.poll();
    		
    		visit(grid, p);
    		
    	   	// up neighbor
        	if (p.i-1>=0 && grid[p.i-1][p.j]=='1') {
        		queue.add(new Pos(p.i-1, p.j));
        	}
        	// down
        	if (p.i+1<=grid.length-1 && grid[p.i+1][p.j]=='1') {
        		queue.add(new Pos(p.i+1, p.j));
        	}
        	// left
        	if (p.j-1>=0 && grid[p.i][p.j-1]=='1') {
        		queue.add(new Pos(p.i, p.j-1));
        	}
        	// right
        	if (p.j+1<=grid[0].length-1 && grid[p.i][p.j+1]=='1') {
        		queue.add(new Pos(p.i, p.j+1));
        	}
    		
    	}
    }
    
    void visit(char[][] grid, Pos p) {
    	grid[p.i][p.j] = '0';
    }
    
    private static class Pos {
    	
    	int i;
    	int j;
    	
    	Pos (int i, int j){
    		this.i = i;
    		this.j = j;
    	}
    	
    }
}
