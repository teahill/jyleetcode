package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * https://leetcode.com/problems/majority-element/
 * 
 * @author jyang
 *
 */

public class LC169_MajorityElement {
	
    public int majorityElement(int[] nums) {
    	
        if (nums.length==1){
            return nums[0];
        }
        
        Map<Integer, ElementCount> map = new HashMap<Integer, ElementCount>();
        
        for (int i=0; i<nums.length; i++){
            
            ElementCount ec = map.get(nums[i]);
            
            if (ec!=null){
                ec.count++;
                
                if (ec.count>=nums.length/2){
                    return ec.value;
                }
            }
            else {
                ec = new ElementCount(nums[i], 1);
                map.put(nums[i], ec);
            }
        }
        
        return 0;
    }
    
    private static class ElementCount {
        int value;
        int count;
        
        ElementCount(int v, int c){
            value = v;
            count = c;
        }
    }

}
