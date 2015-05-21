package com.leetcode.jyang;

import java.util.Arrays;

/**
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author jyang
 *
 */

public class LC105_BuildTreePreInOrder {
	
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	
    	if (preorder.length==0 || inorder.length==0)	return null;
    	if (preorder.length!=inorder.length)	return null;
    	
    	int rootVal = preorder[0];
    	
    	int i;
    	
    	for (i=0; i<inorder.length; i++){
    		if (inorder[i]==rootVal){
    			break;
    		}
    	}
    	
    	int[] inorderLeft = Arrays.copyOfRange(inorder, 0, i);
    	int[] inorderRight= Arrays.copyOfRange(inorder, i+1, inorder.length);
    	
       	int[] preorderLeft = Arrays.copyOfRange(preorder, 1, i+1);
    	int[] preorderRight= Arrays.copyOfRange(preorder, i+1, preorder.length);
    	
    	TreeNode root = new TreeNode(rootVal);
    	
    	root.left = buildTree(preorderLeft, inorderLeft);
    	root.right = buildTree(preorderRight, inorderRight);
    	
        return root;
    }
	
}
