package com.leetcode.jyang;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical and the nodes
 * have the same value.
 * 
 * @author jyang
 *
 */

public class LC100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return serilizeBinaryTree(p).equals(serilizeBinaryTree(q));
    }

	public String serilizeBinaryTree(TreeNode root){
		
		if (root==null){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	sb.append("#,");
                	continue;
                }                
                
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                    nullLevel = false;
                }
                else {
                	nextLevel.add(null);
                }
                
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                    nullLevel = false;
                }
                else {
                	nextLevel.add(null);
                }
                
                sb.append(currentNode.val + ",");
            }
            
            if (nullLevel)
            	break;
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            nullLevel = true;
        }
		
		return sb.toString();
	}
	
	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if(p==null && q==null) return true;
		if(p==null || q==null) return false;
		return p.val==q.val && isSameTree2(p.left,q.left) && isSameTree2(p.right,q.right);
	}
}
