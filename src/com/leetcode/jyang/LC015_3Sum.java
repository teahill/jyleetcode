package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Level: Medium
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find
 * all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
 * The solution set must not contain duplicate triplets.
 *   For example, given array S = {-1 0 1 2 -1 -4},
 *
 *   A solution set is:
 *   (-1, 0, 1)
 *   (-1, -1, 2)
 * 
 * 
 * @author jyang
 *
 * It has been theoretically proven that the fastest solution for this problem is O(n^2).
 *
 */
public class LC015_3Sum {
	
	/*
	Input:	[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
			[-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]
	Output:	[[-4,-2,6],[-4,0,4],[-2,-2,4],[-2,0,2]]
	Expected:	[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
	*/	
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	
	public List<List<Integer>> threeSum(int[] num) {
		
	    Arrays.sort(num);
	    
	    List<List<Integer>> res = new LinkedList<List<Integer>>(); 
	    
	    for (int i = 0; i<num.length; i++){
	    	
	    	if (i > 0 && num[i] == num[i-1]) continue;
	    	
	    	int start = i+1;
	    	int end = num.length - 1;
	    	
	    	while (start < end){
	    		
	    		int sum = num[i] + num[start] + num[end];
	    		
	    		if (sum < 0){
	    			start++;
	    			while (start < end && num[start]==num[start-1]){
	    				start++;
	    			}
	    		}
	    		else if (sum > 0){
	    			end--;
	    			while (start < end && num[end]==num[end+1]){
	    				end--;
	    			}
	    		}
	    		else {
	    			List<Integer> r = new ArrayList<Integer>();
	    			
	    			r.add(num[i]);
	    			r.add(num[start]);
	    			r.add(num[end]);
	    			
	    			res.add(r);
	    			
	    			start++;
	    			while (start < end && num[start]==num[start-1]){
	    				start++;
	    			}
	    			
	    			end--;
	    			while (start < end && num[end]==num[end+1]){
	    				end--;
	    			}	    				    			
	    		}	    		
	    	}
	    }
	    
	    return res;
	}
	
	public List<List<Integer>> threeSum4(int[] num) {
			
	    Arrays.sort(num);
	    
	    List<List<Integer>> res = new LinkedList<List<Integer>>(); 
	    
	    for (int i = 0; i< num.length; i++) {
	    	map.put(num[i], i);
	    }
	    
	    for (int i = 0; i<num.length; i++){
	        
	    	if (i > 0 && num[i] == num[i-1]) continue;
	        
	    	for (int j = i+1; j<num.length; j++){
	    		
	            if (j > i+1 && num[j] == num[j-1]) continue;
	            
	            if (map.containsKey(0-num[i] - num[j])){
	                if (map.get(0-num[i]-num[j]) > j){
	                    // we found a match
	                    LinkedList<Integer> r = new LinkedList<Integer>();
	                    r.add(num[i]);
	                    r.add(num[j]);
	                    r.add(0-num[i] - num[j]);
	                    
	                    res.add(r);
	                }

	            }
	        }
	    }
	    return res;

	}
	
	// this gets the correct results but TLE ...
	public List<List<Integer>> threeSum2(int[] num) {
		
		int target = 0;
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		if (num==null || num.length<3){
			return results;
		}
		
		Arrays.sort(num);
		
		for (int i=0; i<num.length; i++){
			
			for (int j=i+1; j<num.length; j++){
				
				int gap = target -(num[i]+num[j]);
				
				if (gap < num[i] || gap > num[num.length-1]){
					continue;
				}			
				
				int m = binarySearch(num, j+1, num.length-1, gap);
				
				if (m!=-1){
					List<Integer> res = new ArrayList<Integer>(3);
					res.add(num[i]);
					res.add(num[j]);
					res.add(num[m]);
					
					if (!results.contains(res)){
						results.add(res);						
					}
				}
			}
		}
	
		return results;
	}	

	// this won't work
	public List<List<Integer>> threeSum3(int[] num) {
		
		int target = 0;
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		
		if (num==null || num.length<3){
			return results;
		}
		
		Arrays.sort(num);
		
		int l = 0;
		int r = num.length - 1;
		
		while (l < r){
			
			int gap = target - (num[l] + num[r]);

			// gap in range, lets find a possible match
			if (gap >= num[l+1] && gap <= num[r-1]){				
				// could do a binary search here
				for (int i=l+1; i<=r-1; i++){
					if (num[i]==gap){
						List<Integer> res = new ArrayList<Integer>(3);
						res.add(num[l]);
						res.add(num[i]);
						res.add(num[r]);
						
						if (!results.contains(res)){
							results.add(res);						
						}
						
						break;
					}
				}
			}

			// lets figure out when end to move
			int newGapWithLeftMoved  = target - (num[l+1] + num[r]);
			int newGapWithRightMoved = target - (num[l] + num[r-1]);
			
			// only move left ptr and still in range
			if (l+2<num.length-1 && newGapWithLeftMoved >= num[l+2] && newGapWithLeftMoved <= num[r-1]){
				l++;
			}
			// only move right ptr and still in range
			else if (r-2>=0 && newGapWithRightMoved >= num[l+1] && newGapWithRightMoved <= num[r-2]){
				r--;
			}
			// no luck, lets move both
			else {
				l++;
				r--;
			}
		}
			
		return results;
	}
	
	public int binarySearch(int[] num, int low, int high, int target) {
		
		if (low > high){
			return -1;
		}
		
		int left = low;
		int right = high;
		
		while (left <= right){
			
			int mid = left + (right-left)/2;
			
			if (target < num[mid]) {
				right = mid-1;
			}
			else if (target > num[mid]) {
				left = mid+1;
			}
			else {
				return mid;
			}
		}
		
		return -1;	
	}

}



/*
Input:	[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
		[-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6]
Output:	[[-4,-2,6],[-4,0,4],[-2,-2,4],[-2,0,2]]
Expected:	[[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
*/
