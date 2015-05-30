package com.leetcode.jyang;

import java.util.Iterator;
import java.util.Stack;

/**
 * 
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent
 * a number.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Find the total sum of all root-to-leaf numbers.
 * 
 * For example,
 * 
 *    1
 *   / \
 *  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * 
 * Return the sum = 12 + 13 = 25.
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC129_SumRootToLeaf {

	private int sum = 0;
	
    public int sumNumbers(TreeNode root) {
    	
    	if (root==null)		return 0;
    	
    	Stack<Integer> path = new Stack<Integer>();
    	
    	helper(root, path);
    	
        return sum;
    }
	
    public void helper(TreeNode root, Stack<Integer> path) {
    	
    	if (root==null){
    		return;
    	}
    	
    	path.add(root.val);
    	
    	if (root.left==null && root.right==null){
    		Integer[] tmp = new Integer[path.size()];
    		sum += getPathSum(path.toArray(tmp));
    		return;
    	}
    	
    	if (root.left!=null){
    		helper(root.left, path);
    		path.pop();
    	}
    	
       	if (root.right!=null){
    		helper(root.right, path);
    		path.pop();
    	}
    }
    
    private int getPathSum(Integer[] path) {
    	
    	int res = 0; 	
    	int pow = 0;
    	
    	for (int i=path.length -1; i>=0; i--){
    		res += path[i] * Math.pow(10, pow);
    		pow++;
    	}

    	return res;
    }
}
