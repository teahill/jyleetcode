package com.leetcode.jyang;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 *      
 * The flattened tree should look like:
 * 
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *            
 * Hints:
 * If you notice carefully in the flattened tree, each node's right child points to the next
 * node of a pre-order traversal.
 * 
 * 
 * @author jyang
 *
 */

public class LC114_FlattenBinaryTree {
	
    public void flatten(TreeNode root) {
    	
    	if (root==null)	return;
    	
    	helper(root);
    }
	
    public TreeNode helper(TreeNode root){
    	
    	if (root==null)	return null;
    	
    	TreeNode oldRight = root.right;
    	
    	if (root.left!=null){
    		root.right = helper(root.left);
    		root.left = null;
    	}
    	
    	if (oldRight!=null && root.right!=null /* && root.right!=oldRight */){
    		
    		TreeNode tmp = root;
    		TreeNode prev = root;
    		while (tmp.right!=null && tmp.right!=oldRight){
    			prev = tmp;
    			tmp = tmp.right;
    		}		
    		
    		if (tmp==oldRight){
    			prev.right = helper(oldRight);
    			prev.left = null;
    		}
    		else {
       			tmp.right = helper(oldRight);
    			tmp.left = null;
    		}
    	}
    	
    	return root;
    }
}
