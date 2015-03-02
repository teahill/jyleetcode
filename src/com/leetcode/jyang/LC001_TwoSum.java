package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * LEVEL: MEDIUM
 * 
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @author jyang
 *
 */


public class LC001_TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		
		int [] pos = new int[]{0, 0};
		
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for (int i=0; i<numbers.length; i++) {
			
			Integer second = m.get(numbers[i]);
			
			if (second!=null){
				pos[0]=second+1;
				pos[1]=i+1;
				
				return pos;
			}
			else {
				m.put(target-numbers[i], i);
			}
		}
		
		return pos;
	}

	public static void main(String[] args) {
		
		//int[] numbers = new int[]{2,7,11,15};
		//int target = 9;
		
		//int[] numbers = new int[]{150,24,79,50,88,345,3};
		//int target = 200;
		int[] numbers = new int[]{230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
		int target = 542;
		
		LC001_TwoSum ts = new LC001_TwoSum();
		
		int[] pos = ts.twoSum(numbers, target);
		
		System.out.println("Index1=" + pos[0]);
		System.out.println("Index2=" + pos[1]);
	}
}
