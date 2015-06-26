package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * 
 * @author jyang
 *
 */

public class LC228_SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		
		List<String> res = new ArrayList<String>();
		
		if (nums==null || nums.length==0){
			return res;
		}
		
		int p1 = 0;
		int p2 = 0;
		
		while (p1 < nums.length && p2 < nums.length){
			
			while (p2 < nums.length-1 && nums[p2+1] - nums[p2] == 1 ){
				p2++;
			}
			
			String s;
			if (p1==p2){
				s = String.valueOf(nums[p1]);
				p1++;
				p2++;
			}
			else {
				s = nums[p1] + "->" + nums[p2];
				p2++;
				p1 = p2;
			}
			
			res.add(s);
		}
		
		return res;     
	}
	
}
