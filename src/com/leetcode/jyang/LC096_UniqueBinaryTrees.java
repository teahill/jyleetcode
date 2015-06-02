package com.leetcode.jyang;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * 
 * @author jyang
 * 
 * https://leetcode.com/discuss/24282/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
 *
 */

public class LC096_UniqueBinaryTrees {

    public int numTrees(int n) {
    	
    	if (n==0) return 0;
    	
    	int[] res = new int[n+1];
    	
    	res[0] = 1;
    	res[1] = 1;
        
    	for (int i=2; i<=n; i++){
    		for (int j=1; j<=i; j++)
    			res[i] += res[j-1] * res[i-j];
    	}
    	
    	return res[n];
    }
	
}
