package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * Level: Medium
 * 
 * 
 * Given an integer, convert it to a roman numeral.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * @author jyang
 *
 */

public class LC012_Integer2Roman {
	
	Map<Integer, String> map = new HashMap<Integer, String>();
	
	int[] marks = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	
	public String intToRoman(int num) {

		map.put(1, "I");
		map.put(4, "IV");
		map.put(5, "V");
		map.put(9, "IX");
		map.put(10, "X");
		map.put(40, "XL");
		map.put(50, "L");
		map.put(90, "XC");
		map.put(100, "C");
		map.put(400, "CD");
		map.put(500, "D");
		map.put(900, "CM");
		map.put(1000, "M");
		
		Result r = new Result();
		
		getRoman(r, num);
		
		return r.s;
	}
	
	private void getRoman(Result r, int n){
		
		if (n==0){
			return;
		}
		
		int i, q = 0;
		
		for (i = marks.length-1; i>=0; i--){
			q = n/marks[i];
			if (q>0) break;
		}
		
		String rn = map.get(marks[i]);
		//System.out.println("rn = " + rn);
		for (int j=0; j<q; j++){
			r.s += rn;
		}
		
		int remain = n - q*marks[i];
		getRoman(r, remain);
	}
	
	public static class Result {
		String s = "";
	}
	
	public static void main(String[] args) {
		
		int[] input = new int[] {
			1,
			4,
			5,
			8,
			9,
			10,
			11,
			14,
			15,
			20,
			28,
			40,
			45,
			90,
			97,
			100,
			143,
			493,
			500,
			876,
			2071,
			3999			
		};
		
		LC012_Integer2Roman lc012 = new LC012_Integer2Roman();
		
		for (int i=0; i<input.length; i++){
			System.out.println("Convert to Roman of " + input[i] + " is " + lc012.intToRoman(input[i]));
		}
		
	}
	
}
