package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public int maxArea2(int[] height) {
    	
    	if (height==null || height.length==0){
    		return 0;
    	}
    	
    	int maxArea = 0;
    	
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	List<Integer> hList = new ArrayList<Integer>();
    	
//    	int maxHeight = 0;
//    	int minHeight = Integer.MAX_VALUE;
//    	
    	for (int i=0; i<height.length; i++){
    		
    		hList.add(height[i]);
    		
    		List<Integer> list = map.get(height[i]);
    		
    		if (list!=null){
    			list.add(i);
    		}
    		else {
    			list = new ArrayList<Integer>();
    			list.add(i);
    			map.put(height[i], list);
    		}
    	}
    	
    	Collections.sort(hList);
    	
    	
    	
    	for (int i=0; i<hList.size(); i++){
    		System.out.println(hList.get(i));
    	}
    	
    	
    	
    	for (Integer key : hList){
    		
    		List<Integer> values = map.get(key);
    		
    		Collections.sort(values);
    		
    		int maxLen = Math.abs(values.get(0) - values.get(values.size()-1));
    		int area = key * maxLen;
    		
    		maxArea = Math.max(maxArea, area);
    	}

    	return maxArea;
    }
	
	// naive solution
    public int maxArea(int[] height) {
    	
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
    //*/
    
	public static void main(String[] args) {

		int[][] input = new int[][] {
			{1,2,1,4,2},
			{2,5,4,3,7},
			{9,4,3,0,8},
		};
		
		LC011_WaterContainer lc011 = new LC011_WaterContainer();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Max area of input: is " + lc011.maxArea(input[i]));
		}
	}
}
