package com.leetcode.jyang;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC179_LargestNumber {
	
    public String largestNumber(int[] num) { 
    	
    	if (num.length==0)	return "";
    	
    	NumberComparator c = new NumberComparator();
    	
    	String[] a = new String[num.length];
     	
    	for (int i=0; i<num.length; i++){
    		a[i] = String.valueOf(num[i]);
    	}
        
    	Arrays.sort(a, c);
    	
    	if (a[a.length-1].equals("0")){
    		return "0";
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for (int i=a.length-1; i>=0; i--){
    		sb.append(a[i]);
    	}
    	
    	return sb.toString();
    }
    
    private static class NumberComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			
			if (s1.charAt(0)==s2.charAt(0) && s1.length()!=s2.length()){			
				int s1s2 = Integer.valueOf(s1+s2);
				int s2s1 = Integer.valueOf(s2+s1);
				
				return s1s2 > s2s1 ? 1 : -1;
			}
			
			return s1.compareTo(s2);
		}
    	
    }
}
