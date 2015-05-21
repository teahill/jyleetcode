package com.leetcode.jyang;

import java.util.Arrays;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * 
 * @author jyang
 *
 */

public class LC106_BuildTreeInPostOrder {
	
//	int[] inorder   = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 11, 13, 15, 19, 20, 21, 24};	
//	int[] postorder = new int[]{1, 3, 2, 5, 8, 6, 4, 11, 15, 13, 20, 24, 21, 19, 9};

	public TreeNode buildTree(int[] inorder, int[] postorder) {
	    
	   	if (postorder.length==0 || inorder.length==0)	return null;
    	if (postorder.length!=inorder.length)	return null;
    	
    	int rootVal = postorder[postorder.length-1];
    	
    	int i;
    	
    	for (i=0; i<inorder.length; i++){
    		if (inorder[i]==rootVal){
    			break;
    		}
    	}
    	
    	int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
    	int[] inorderRight= Arrays.copyOfRange(inorder, i+1, inorder.length);
    	
       	int[] postorderLeft = Arrays.copyOfRange(postorder, 0, i);
    	int[] postorderRight= Arrays.copyOfRange(postorder, i, postorder.length-1);
    	
    	TreeNode root = new TreeNode(rootVal);
    	
    	root.left = buildTree(inorderLeft, postorderLeft);
    	root.right = buildTree(inorderRight, postorderRight);
    	
        return root;
    }

}
