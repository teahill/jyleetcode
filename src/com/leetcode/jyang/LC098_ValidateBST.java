package com.leetcode.jyang;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * @author jyang
 *
 */

public class LC098_ValidateBST {

    public boolean isValidBST(TreeNode root) {

    	if (root==null)	return true;
    	
        if (root.left!=null) {
        	if (root.val <= root.left.val)	return false;       	
        	if (!isValidBST(root.left))		return false;
        }
        
        if (root.right!=null) {
        	if (root.val >= root.right.val)	return false;       	
        	if (!isValidBST(root.right))	return false;
        }
        
        return true;
    }
	
    public boolean isValidBST2ß(TreeNode root) {
        if(root ==null)
        return true;
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long min, long max)
    {
        if(root == null)
        return true;
        if(root.val < min || root.val > max)
        return false;
        return isValidBST(root.left,min,(long)root.val-1)&&isValidBST(root.right,(long)root.val+1,max);
    }
}
