package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and
 * j is at most k.
 * 
 * 
 * @author jyang
 *
 */

public class LC220_ContainsDuplicateIII {
	
	// This solution is O(nlog(k)).
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	
    	if (nums==null || nums.length <=1) return false;
    	if (k < 1 || t < 0) return false;

    	TreeSet<Integer> ts = new TreeSet<Integer>();
    	
    	for (int i=0; i< nums.length; i++){
    		
    		// high bound in the current set 
    		Integer high = ts.floor(nums[i] + t);
    		
    		// low bound in the current set 
    		Integer low = ts.ceiling(nums[i] - t);
    		
    		if (high!=null && nums[i] <= high || 
    			low !=null && nums[i] >= low){
    			return true;
    		}
    		
    		ts.add(nums[i]);
    		
    		if (i-k>=0){
    			ts.remove(nums[i-k]);
    		}
    	}
    	
    	return false;
    }
	
    /*
     * https://leetcode.com/discuss/38206/ac-o-n-solution-in-java-using-buckets-with-explanation
     * 
     * As a follow-up question, it naturally also requires maintaining a window of size k. When t == 0, it
     * reduces to the previous question so we just reuse the solution.
     * 
     * Since there is now a constraint on the range of the values of the elements to be considered duplicates,
     * it reminds us of doing a range check which is implemented in tree data structure and would take O(LogN) 
     * if a balanced tree structure is used, or doing a bucket check which is constant time. We shall just discuss
     * the idea using bucket here.
     * 
     * Bucketing means we map a range of values to the a bucket. For example, if the bucket size is 3, we consider
     * 0, 1, 2 all map to the same bucket. However, if t == 3, (0, 3) is a considered duplicates but does not map 
     * to the same bucket. This is fine since we are checking the buckets immediately before and after as well. 
     * So, as a rule of thumb, just make sure the size of the bucket is reasonable such that elements having the 
     * same bucket is immediately considered duplicates or duplicates must lie within adjacent buckets. So this 
     * actually gives us a range of possible bucket size, i.e. t and t + 1. We just choose it to be t and a bucket
     * mapping to be num / t.
     * 
     * Another complication is that negative ints are allowed. A simple num / t just shrinks everything towards 0. 
     * Therefore, we can just reposition every element to start from Integer.MIN_VALUE.
     * 
     */
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        
    	if (k < 1 || t < 0) return false;
        
    	Map<Long, Long> map = new HashMap<Long, Long>();
        
    	for (int i = 0; i < nums.length; i++) {
            long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappedNum / ((long) t + 1);
            if (map.containsKey(bucket)
                    || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
                        || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t))
                            return true;
            if (map.entrySet().size() >= k) {
                long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappedNum);
        }
    	
        return false;
    }

	// this implementation is O(nk) and not accepted by OJ.
    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        
    	if (nums==null || nums.length <=1) return false;
    	if (k < 1 || t < 0) return false;

       	for (int i=0; i< nums.length; i++){
       		
       		int start = i-k>0 ? i-k : 0;
       		int end = i+k>nums.length-1 ? nums.length-1 : i+k;
       		
       		for (int j=start; j<=end; j++){
       			
       			if (i==j)	continue;
       			
       			if (Math.abs(nums[i]-nums[j])<=t){
       				return true;
       			}
       		}
       	}
    	
    	return false;
    }
	
}
