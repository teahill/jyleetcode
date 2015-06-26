package com.leetcode.jyang;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * 
 * @author jyang
 *
 * Sieve of Eratosthenes
 *
 */

public class LC204_CountPrimes {

    public int countPrimes(int n) {
    	
    	if (n<=1)	return 0;
    	
    	boolean[] sieve = new boolean[n];
    	
    	for (int i=2; i*i<n; i++){
    		
    		if (sieve[i]==true)	continue;
    		
    		for (int j=i*i; j<n; j+=i){
    			sieve[j] = true;
    		}
    	}
        
    	int cnt = 0;
    	for (int k=2; k<n; k++){
    		if (!sieve[k]){
    			cnt++;
    			//System.out.print(k + " ");
    		}
    	}
    	
    	return cnt;
    }
	
}
