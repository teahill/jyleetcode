package com.leetcode.jyang;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down
 * to the nearest leaf node.
 * 
 * 
 * @author jyang
 *
 */

public class LC111_MinDepthBinaryTree {
	
    public int minDepth(TreeNode root) {
    	
    	if (root==null)		return 0;
    	
    	if (root.left==null && root.right==null){
    		return 1;
    	}
    	else if (root.left==null){
    		return 1 + minDepth(root.right);
    	}
    	else if (root.right==null){
    		return 1 + minDepth(root.left);
    	}
    	else {
        	return 1 + Math.min(minDepth(root.left),  minDepth(root.right));	
    	}
    }

}
