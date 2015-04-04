package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets. 
 *
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 *
 * For example,
 * If S = [1,2,2], a solution is: 
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * 
 * 
 * Input:	
           [4,1,0]
                		
           Output:	
           [[],[4],[1],[0],[4,1],[4,0],[1,0],[4,1,0]]	
              
           Expected:	
           [[],[0],[0,1],[0,1,4],[0,4],[1],[1,4],[4]
 * 
 * @author jyang
 *
 */

public class LC090_SubsetsII {
	
	public List<List<Integer>> subsetsWithDup2(int[] num) {
		
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    
	    int len = num.length;
	    if (len == 0) return res;
	    
	    Arrays.sort(num);

	    res.add(new ArrayList<Integer>()); // first, need to add the subset of num[0]
	    res.add(new ArrayList<Integer>());
	    res.get(1).add(num[0]);

	    int prev = 1; // this is the number of lists that the previous number was added in.
	                   // if the current number is same as the prev one, it'll be only added in the 
	                   // lists that has the prev number.

	    for (int i = 1; i < len ; ++i){
	        int size = res.size();
	        if (num[i]!=num[i-1])   // if different
	            prev = size;       // this means add num[i] to all lists in res;
	        for (int j = size-prev; j < size; ++j){
	            List<Integer> l = new ArrayList<Integer>(res.get(j));
	            l.add(num[i]);
	            res.add(l);
	        }
	    }
	    
	    return res;
	}
	
	// The following BT solution gives the correct list of subsets but the order is wrong
	
    public List<List<Integer>> subsetsWithDup(int[] num) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	res.add(Collections.<Integer> emptyList());
    	
    	List<Integer> list = new ArrayList<Integer>();
    	
    	Arrays.sort(num);
    	
    	for (int i=0; i<num.length; i++){
    		subsetsWithDupBT(list, num, i+1, 0, res);
    	}
    	
    	return res;
    }

    private void subsetsWithDupBT(List<Integer> list, int[] num, int k, int start, List<List<Integer>> res){
    	
    	if (k==0){
    		List<Integer> tmp = new ArrayList<Integer>(list);
    		if (!res.contains(tmp)){
        		res.add(tmp);    			
    		}    		
    		return;
    	}
    	
    	for (int i=start; i<num.length; i++){    		
    		list.add(num[i]);
    		subsetsWithDupBT(list, num, k-1, i+1, res);
    		list.remove(list.size()-1);    		
    	}    	
    }
}
