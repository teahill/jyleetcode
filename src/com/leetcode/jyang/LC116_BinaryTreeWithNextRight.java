package com.leetcode.jyang;

/**
 * Given a binary tree
 *
 *   struct TreeLinkNode {
 *     TreeLinkNode *left;
 *     TreeLinkNode *right;
 *     TreeLinkNode *next;
 *   }
 *   
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * For example, given the following perfect binary tree,
 * 
 *         1
 *       /  \
 *      2    3
 *     / \  / \
 *    4  5  6  7
 *    
 * After calling your function, the tree should look like:
 * 
 *        1 -> NULL
 *       /  \
 *      2 -> 3 -> NULL
 *     / \  / \
 *    4->5->6->7 -> NULL
 * 
 * 
 * @author jyang
 *
 */

public class LC116_BinaryTreeWithNextRight {

    public void connect(TreeLinkNode root) {
    	
    	TreeLinkNode current = root;
    	TreeLinkNode next;

    	while (current!=null){
    		
    		next = current.left;
    		
    		while (current!=null && current.left!=null){
    			
    			current.left.next = current.right;
    			if (current.next!=null){
    				current.right.next = current.next.left;
    			}
    			
    			current = current.next;
    		}
    		
    		current = next;    		
    	}
    }
}
