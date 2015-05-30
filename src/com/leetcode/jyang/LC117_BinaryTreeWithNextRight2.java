package com.leetcode.jyang;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 *
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * 
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 * 
 *       1
 *      /  \
 *     2    3
 *    / \    \
 *   4   5    7
 * 
 * After calling your function, the tree should look like:
 *
 *       1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \    \
 *   4-> 5 -> 7 -> NULL
 * 
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC117_BinaryTreeWithNextRight2 {
	
    public void connect(TreeLinkNode root) {
    	
       	TreeLinkNode current = root;
    	TreeLinkNode next;

    	while (current!=null){
    		
    		if (current.left!=null){
    			next = current.left;
    		}
    		else if (current.right!=null){
    			next = current.right;
    		}	
    		else {
    			next = null;
    		}
    		
    		while (current!=null){
    			
    			if (current.left!=null){
        			current.left.next = current.right;    				
    			}

    			if (current.next!=null){
    				if (current.right!=null){
    					if (current.next.left!=null){
    						current.right.next = current.next.left;
    					}
    					else {
    						current.right.next = current.next.right;
    					}
    				}
    				else if (current.left!=null){
       					if (current.next.left!=null){
    						current.left.next = current.next.left;
    					}
    					else {
    						current.left.next = current.next.right;
    					}
    				}
    			}
    			
    			current = current.next;
    		}
    		
    		current = next;    		
    	}        
    }
}
