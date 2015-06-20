package com.leetcode.jyang;

/**
 * Invert a binary tree.
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * 
 * @author jyang
 *
 */

public class LC226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
     
    	if (root==null)		return null;
    	
    	TreeNode left = invertTree(root.left);
    	TreeNode right = invertTree(root.right);
    	
    	root.left = right;
    	root.right = left;
    	
    	return root;
    }
}
