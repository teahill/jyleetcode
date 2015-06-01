package com.leetcode.jyang;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with
 * the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is
 * the height of the tree.
 * 
 * Your BSTIterator will be called like this:
 * 
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 * 
 * 
 * @author jyang
 * 
 * This problemis essentially the same as Problem 94, using a stack to do in-order traversal.
 *
 */

public class LC173_BinarySearchTreeIterator {
	
	Stack<TreeNode> nodes;
	TreeNode current;
	
    public LC173_BinarySearchTreeIterator(TreeNode root) {   
    	
    	nodes = new Stack<TreeNode>();
    	current = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    	
    	return !nodes.isEmpty() || current!=null;
    }

    /** @return the next smallest number */
    public int next() {
    	
    	while (current!=null){
    		nodes.push(current);
    		current = current.left;
    	}
        
    	TreeNode tn = nodes.pop();
    	current = tn.right;
    	
    	return tn.val;
    }
	
}
