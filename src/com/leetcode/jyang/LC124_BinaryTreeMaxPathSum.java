package com.leetcode.jyang;

/**
 * 
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *      1
 *     / \
 *    2   3
 *    
 * Return 6.
 * 
 * 
 * @author jyang
 * 
 * NOTE: any node can have a negative value
 *
 */

public class LC124_BinaryTreeMaxPathSum {

	int max = Integer.MIN_VALUE;
	
    public int maxPathSum(TreeNode root) {
        
    	if (root==null){
    		return 0;
    	}
    	
    	helper(root);
    	
    	return max;
    }
	
    /*
     * Find the largest path sum among all the arches rooted at root. 
     * 
     */
    public int helper(TreeNode root){
    	
    	if (root==null){
    		return 0;
    	}
    	
    	int left = helper(root.left);
    	int right = helper(root.right);
    	
    	if (left < 0)	left = 0;
    	if (right < 0)	right = 0;
    	
    	int sum = left + right + root.val;
    	
    	if (sum > max)	max = sum;
    	   	
    	return root.val + Math.max(left, right);
    }
}
