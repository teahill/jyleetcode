package com.leetcode.jyang;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * 
 * 
 * @author jyang
 *
 */

public class LC104_MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
     
    	if (root==null)		return 0;
    	
    	if (root.left==null && root.right==null){
    		return 1;
    	}
    	else if (root.left==null){
    		return 1 + maxDepth(root.right);
    	}
    	else if (root.right==null){
    		return 1 + maxDepth(root.left);
    	}
    	else {
        	return 1 + Math.max(maxDepth(root.left),  maxDepth(root.right));	
    	}
    }
	
}
