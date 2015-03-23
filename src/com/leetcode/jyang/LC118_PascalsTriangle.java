package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 * Return
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * @author jyang
 *
 */

public class LC118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if (numRows<=0){
    		return res;
    	}
    	
    	int i = 1;
    	
    	while (i<=numRows){
    		
    		Integer[] row = new Integer[i];
    		
    		row[0] = 1;
    		row[i-1] = 1;
    		
    		List<Integer> prev = null;
    		
    		if (!res.isEmpty()){
    			prev = res.get(i-2);
    		}
    		   	
    		if (prev!=null){
	    		for (int j=1; j<i-1; j++){
	    			row[j] = prev.get(j-1) + prev.get(j);
	    		}
    		}
    		
    		res.add(Arrays.asList(row));
    		i++;
    	}
    	
    	return res;

    }
	
}
