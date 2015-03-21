package com.leetcode.jyang;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 * adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * A better example:
 * [
 *     [-1],
 *    [2, 3],
 *   [1,-1,-3]
 * ]
 * 
 * The min path is -1->3->-3, not -1->2->-1.
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number
 * of rows in the triangle.
 * 
 * 
 * @author jyang
 *
 */

public class LC120_Triangle {
	
	Map<String, Integer> map = new HashMap<String, Integer>();
	
    public int minimumTotal(List<List<Integer>> triangle) {
    	
    	if (triangle==null || triangle.isEmpty()){
    		return 0;
    	}
    	
    	return findMin(triangle, 0, 0);
    }
    
    /**
     * Find the minimum total for the sub tree rooted at (level, pos).
     * 
     * @param triangle
     * @param level
     * @param pos
     * @return
     */
    public int findMin(List<List<Integer>> triangle, int level, int pos){
    	
    	String key = level + "-" + pos;
    	if (map.containsKey(key)){
    		return map.get(key);
    	}
    	
       	int val = triangle.get(level).get(pos);
    	
    	if (level==triangle.size()-1){
    		map.put(key, val);
    		return val;
    	}
    	else {
    		int nextMin = Math.min(findMin(triangle, level+1, pos), findMin(triangle, level+1, pos+1));
    		map.put(key, val + nextMin);
    		return val + nextMin;
    	}
    	
    }
}
