package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

public class LC448_NumbersDisappeared {
	
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
    	for (int i=0; i<nums.length; i++) {
    		
    		int val = nums[i];
    		
    		while (val!=nums[val-1]) {
    			int tmp = nums[val-1];
    			nums[val-1] = val;
    			val = tmp;
    		}
    	}
        
        List<Integer> res = new ArrayList<Integer>();
        
        for (int j=0; j<nums.length; j++){
            if (nums[j]!=j+1){
                res.add(j+1);
            }
        }
        
        return res;
    }

}
