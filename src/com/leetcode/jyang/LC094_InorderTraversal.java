package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * 
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * @author jyang
 *
 */

public class LC094_InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
    	
    	List<Integer> res = new ArrayList<Integer>(); 	
    	if (root==null)		return res;
    	
    	Set<TreeNode> processed = new HashSet<TreeNode>();
    	
    	List<TreeNode> thisLevel = new ArrayList<TreeNode>();
    	List<TreeNode> nextLevel = new ArrayList<TreeNode>();
    	
    	thisLevel.add(root);
    	
    	while (true){
    		
    		for (TreeNode node : thisLevel){
    			
    			if (node.left!=null)	
    				nextLevel.add(node.left);
    			if (!processed.contains(node)) 
    				nextLevel.add(node);
    			if (node.right!=null)	
    				nextLevel.add(node.right);
    			
       			processed.add(node);
    		}
    		
    		if (nextLevel.isEmpty()){
    			break;
    		}
    		else {
    			thisLevel = nextLevel;
    			nextLevel = new ArrayList<TreeNode>();
    		}
    	}

    	for (TreeNode node : thisLevel){
    		res.add(node.val);
    	}
    	
        return res;
    }
	
}
