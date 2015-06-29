package com.leetcode.jyang;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using
 * extra memory?
 * 
 * 
 * @author jyang
 *
 * ^ bit operation is communicative, so that A^B = B^A.
 * 
 * So A^B^C^D^A^B^D = A^A^B^B^D^D^C  ->  only C is left out (not being cancelled).
 */

public class LC136_SingleNumber {

	public int singleNumber(int[] nums) {
        int result = 0; 
        for (int i : nums) 
        	result ^= i ; 
        
        return result ; 
    } 
}
