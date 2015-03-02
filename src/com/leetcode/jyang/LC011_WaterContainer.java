package com.leetcode.jyang;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two
 * lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 * @author jyang
 *
 */

public class LC011_WaterContainer {
	
	/**
	 * The idea here is that always consider the furtherest pair of point at the moment.
	 * 
	 * for a particular pair of left and right, if h[left] > h[right], then there is no need
	 * to compute any other left positions with the right, as it is not going to get any better,
	 * so we should just move the right to left by 1. Similarly, if h[left < h[right], we can
	 * skip all the comparisons with all other right positions with respect to the left, so we
	 * simply more left pointer to the right by 1.
	 * 
	 * 
	 * @param height
	 * @return
	 */
	public int maxArea(int[] height) {
		
        int left = 0; 
        int right = height.length-1;
        
        int max = 0;
        
        while (right>left) {
            
            int area = Math.min(height[left], height[right]) * (right-left);
            
            max = Math.max(max, area);
            
            if (height[left] < height[right]){
                left++;
            }
            else if (height[left] >= height[right]){
                right--;
            }
        }
        
        return max;
	}
    
	// naive solution
    public int maxAreaNaive(int[] height) {
    	
    	if (height==null || height.length==0){
    		return 0;
    	}
    	
    	int maxArea = 0;
    	
    	for (int i=0; i<height.length; i++){
    		
    		for (int j=i; j<height.length; j++){
    			
    			int area = Math.min(height[i], height[j]) * (j-i);
    			
    			maxArea = Math.max(maxArea, area);
    		}
    	}
    	
    	return maxArea;
    }
}
