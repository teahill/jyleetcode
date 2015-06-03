package com.leetcode.jyang;

import java.util.LinkedList;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 * 
 * Note:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space
 * solution?
 * 
 * 
 * @author jyang
 *
 */

public class LC099_RecoverBST {

	/*
	 *                  5 
	 *             
	 *            1           11 
     *       
     *         0     4      6    15 
     *       
     *      #   #  #   3  #   7 #   17 
	 * 
	 * 
	 */
	
	public void recoverTree(TreeNode root) {
	    
		List<Integer> nodes = new LinkedList<Integer>();
		
		helper(root, nodes);
		
		LeetCodeUtils.printList(nodes);
	}
	
	public void helper(TreeNode root, List<Integer> nodes) {
		
		if (root==null){
			return;
		}
		
		helper(root.left, nodes);
		nodes.add(root.val);
		helper(root.right, nodes);
	}
}
