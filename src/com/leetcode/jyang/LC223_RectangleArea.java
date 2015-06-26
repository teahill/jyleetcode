package com.leetcode.jyang;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 *
 * Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 * 
 * @author jyang
 *
 * The trick is to detect if there is an overlap and if so what the overlapped area is. The condition
 * to have a overlap is (min(D,H)> max(F,B)) && (min(G,C)>max(A,E)) and the overlapped area is ) ?
 * (min(D,H) - max(F,B))*(min(G,C)-max(A,E)). 
 * 
 * However, the scalability of this one is not good, a more general solution is to do line sweep and use
 * a sorted set to save all the active rectangles.
 *
 */

public class LC223_RectangleArea {
	
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	
        return (C-A)*(D-B) + (G-E)*(H-F) - 
        		(((Math.min(D,H) > Math.max(F,B)) && (Math.min(G,C) > Math.max(A,E)) ) ? 
        			(Math.min(D,H) - Math.max(F,B))*(Math.min(G,C)-Math.max(A,E)):0);   	
    }
}
