package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * 
 * @author jyang
 *
 */

public class LC077_Combinations {
	
    public List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
        if(k>n)	{
        	return res;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
       	//long t1 = System.currentTimeMillis();
       	combineBT(list, 1, n, k, res);
    	//long t2 = System.currentTimeMillis();
    	
    	//System.out.println("Time used: " + (t2-t1));
        
        return res;
    }
    
    
    /* this is a brilliant back tracking algorithm, lightening fast :-)
     * for example, if input vector is 5, 3, the sequence of forming combinations is as:
     * 
     * list: 1, 2, 3 -> harvest
     * backtrack: 3 is removed
     * list: 1, 2, 4 -> harvest
     * backtrack: 4 is removed
     * list: 1, 2, 5 -> harvest
     * backtrack: 5 is removed
     * backtrack: 2 is removed
     * list: 1, 3, 4 -> harvest,
     * ...
     * 
     */
    public void combineBT(List<Integer> list, int start, int n, int k, List<List<Integer>>res){
        
    	if(k==0) {
    		// this is to harvest a valid combination
    		// note a new instance of array list is created out of list
            res.add(new ArrayList<Integer>(list));
            return;
        }
    	
    	/* code with typical backtracking pattern: 
    	 * 
    	 * Start Loop
    	 * 1. do something
    	 * 2. recursive call;
    	 * 3. undo step 1 
    	 * End Loop
    	 * 
    	 * Very similar pattern can be seen in Problem #46
    	 * 
    	 */
        for(int i=start; i<=n; i++) {
            list.add(i);
            combineBT(list, i+1, n, k-1, res);
            list.remove(list.size()-1);	// this is the backtracking part
        }
        
        return;
    }

    
	// The following solution caused TLE as deemed by OJ :-(

    public List<List<Integer>> combine2(int n, int k) {
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if (n<=0 || k<=0 || n<k){
    		return res;
    	}
    	
    	List<Integer> num = new ArrayList<Integer>();
    	
    	for (int i = 0; i<n; i++){
    		num.add(i+1);
    	}
    	
    	if (n==k){
    		res.add(num);
    		return res;
    	}
 
    	long t1 = System.currentTimeMillis();
    	res = combineBT2(num, n, k);
    	long t2 = System.currentTimeMillis();
    	
    	System.out.println("Time used: " + (t2-t1));
    	
    	return res;
    }
    
    public List<List<Integer>> combineBT2(List<Integer> num, int n, int k){
    	
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	
    	if (k==0){
    		res.add(new ArrayList<Integer>());
    		return res;
    	}
    	
    	for (int i=0; i<n; i++){
    		
    		Integer a = num.get(i);		
    		num.remove(a);
    		
    		List<List<Integer>> rRes = combineBT2(num, n-1, k-1);
    		
    		for (List<Integer> l : rRes){
    			l.add(0, a);
    			res.add(l);
    		}   		
    		num.add(i, a);
    	}
   
    	return res;
    }
}
