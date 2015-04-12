package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 *
 * Given a non-negative integer n representing the total number of bits in the code, print the
 *  sequence of gray code. A gray code sequence must begin with 0.
 *
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 *
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * 
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * 
 * 0
 * 1
 * 
 * 00  0
 * 01  1
 * 11  3
 * 10  2
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC089_GrayCode {
	
	/* SOlution 1: iterarive using bit operations
	 * The idea is simple. G(i) = i^ (i/2).
	 * 
	 * i    i  i>>1  i^i>>
	 * 
	 * 0  000  000   000  0
	 * 1  001  000   001  1
	 * 2  010  001   011  3
	 * 3  011  001   010  2
	 * 4  100  010   110  6
	 * 5  101  010   111  4
	 * 6  110  011   101  5
	 * 7  111  011   100  4
	 */
	
	public List<Integer> grayCode(int n){
	    List<Integer> result = new LinkedList<Integer>();
	    
	    for(int i=0;i<1<<n;i++) 
	    	result.add(i^i>>1);  // ^ is XOR bit operator
	    
	    return result;
	}	
	
	// Solution 2: using DP, and the following observation:
	/*
	* n = 1
	* 0
	* 1
	* n=2
	* 0 0
	* 0 1
	* 1 1
	* 1 0
	* 
	* n=3
	* 
	* 0 0 0
	* 0 0 1
	* 0 1 1
	* 0 1 0
	* 1 1 0
	* 1 1 1
	* 1 0 1
	* 1 0 0
	*/
	public List<Integer> grayCode2(int n){
		
		List<Integer> res = new ArrayList<Integer>();
		
		List<String> r = grayCodeDP(n);
		
		for (String s : r){
			try {
				res.add(Integer.parseInt(s, 2));
			}catch (Exception e){				
			}
		}
		
		return res;
	}
	
	private List<String> grayCodeDP(int n){
		
		List<String> res = new ArrayList<String>();
		
		if (n==0){
			res.add(String.valueOf("0"));
			return res;
		}
		
		if (n==1){
			res.add(String.valueOf("0"));
			res.add(String.valueOf("1"));
			return res;
		}
		
		List<String> tmp = grayCodeDP(n-1);
		
		for (int i=0; i<tmp.size(); i++){
			
			String s = "0" + tmp.get(i);
			res.add(s);
		}
		
		for (int i=tmp.size()-1; i>=0; i--){
			
			String s = "1" + tmp.get(i);
			res.add(s);
		}		
		
		return res;
	}

}
