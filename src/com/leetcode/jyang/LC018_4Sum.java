package com.leetcode.jyang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Level: Medium
 * 
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 *  Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a <= b <= c <= d)
 * The solution set must not contain duplicate quadruplets.
 
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *  A solution set is:
 *   (-1,  0, 0, 1)
 *   (-2, -1, 1, 2)
 *   (-2,  0, 0, 2)
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC018_4Sum {

    public List<List<Integer>> fourSum(int[] num, int target) {
    	
    	List<List<Integer>> res = new LinkedList<List<Integer>>(); 
    	
    	if (num.length<4)	return res;
    	
	    Arrays.sort(num);
	    
	    for (int i=0; i<num.length; i++){
	    	
	    	//if (i-1>=0 && num[i]==num[i-1])	continue;
	    	
	    	for (int j=i+1; j<num.length; j++){
	    		
	    		//if (j-1>=0 && num[j]==num[j-1])	continue;
	    		
	    		int start = j+1;
	    		int end = num.length -1;
	    			    		
	    		while (start < end) {
	    			
		    		int sum = num[i] + num[j] + num[start] + num[end];
	    			
		    		if (sum > target){
		    			end--;
		    			while (end > start && num[end]==num[end+1]){
		    				end--;
		    			}
		    		}
		    		else if (sum < target){
		    			start++;
		    			while (start < end && num[start]==num[start-1]){
		    				start++;
		    			}
		    		}
		    		else {
		    			List<Integer> r = new LinkedList<Integer>();
		    			
		    			r.add(num[i]);
		    			r.add(num[j]);
		    			r.add(num[start]);
		    			r.add(num[end]);
		    			
		    			if (!res.contains(r)) res.add(r);
		    			
	    				start++;
		    			while (start < end && num[start]==num[start-1]){
		    				start++;
		    			}

	    				end--;
		    			while (end > start && num[end]==num[end+1]){
		    				end--;
		    			}
		    		}
	    		}
	    	}
	    }

	    return res;
    }

}
