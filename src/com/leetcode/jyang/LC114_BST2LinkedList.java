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

public class LC114_BST2LinkedList {

	
	
    public void flatten(TreeNode root) {
    	
    	if (root==null)	return;
    	
    	helper(root);
    }
	
    public TreeNode helper(TreeNode root){
    	
    	if (root==null)	return null;
    	
    	TreeNode oldRight = root.right;
    	
    	root.right = helper(root.left);
    	
    	
    }
}
