package com.leetcode.jyang;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement pow(x, n).
 *  
 * @author jyang
 *
 */

public class LC050_Pow {
	
	public double myPow(double x, int n) {
		
	   	if (n==0)	return 1.0d;
    	if (n==1)	return x;
    	
    	long m = Math.abs((long)n);;
    	
    	double finalRes = 1.0d;
    	
    	while (m>0) {
    		
    		double res = x;
    		long exp = 1;
    		    		
	    	while (exp << 1 < m){	    		
	    		res *= res;
	    		exp <<= 1;
	    	}
	    	
	    	finalRes *= res;
	    	m -= exp;
		}
		
    	return n > 0 ? finalRes : 1.0d/finalRes;
	}
	
	Map<Long, Double> save = new HashMap<Long, Double>();

	public double myPow2(double x, int n) {
		
	   	if (n==0)	return 1.0d;
    	if (n==1)	return x;
		
    	long m = Math.abs((long)n);
    	
    	double ret = helper(x, m);
    	
    	return n > 0 ? ret : 1.0d/ret; 
	}
	
	private double helper(double x, long n){
		
	   	if (n==0)	return 1.0d;
    	if (n==1)	return x;
    	
    	if (save.containsKey(n)){
    		return save.get(n);
    	}
		
    	double res;
    	
		if (n%2==0){
			res = helper(x, n/2) * helper(x, n/2);
		}
		else {
			res = helper(x, n/2) * helper(x, n/2) * x;
		}		
		
		save.put(n, res);
		
		return res;
	}
	
	// Naive
    public double myPowNaive(double x, int n) {
     
    	if (n==0)	return 0;
    	if (n==1)	return x;
    	   	
    	long m = Math.abs((long)n);
    	
    	double res = x;
    	
    	for (long i=1; i<m; i++){
    		res *= x;
    	}
    	
    	if (n>0){
    		return res; 
    	}
    	else {
    		return 1.0d/res;
    	}
    }
	
}
