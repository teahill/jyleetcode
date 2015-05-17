package com.leetcode.jyang;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the
 * depth of the two subtrees of every node never differ by more than 1.
 * 
 * 
 * 
 * @author jyang
 *
 */
public class LC110_BalancedBinaryTree {
	
	public boolean isBalanced(TreeNode root){
		
		if (root==null)		return true;
		
		if (root.left==null && root.right==null){
			return true;
		}
		
		int hLeft = root.left == null ? 0 : maxDepth(root.left);
		int hRight = root.right == null ? 0 : maxDepth(root.right);
		
		if (Math.abs(hLeft - hRight) > 1){
			return false;
		}
		else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
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
