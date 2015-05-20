package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
    	
    	int c = 0;
    	
    	while (c<3){
    		
    		for (int i=0; i<thisLevel.size(); i++){
    			TreeNode tn = thisLevel.get(i);
    			
    			List<TreeNode> addOn = new ArrayList<TreeNode>();
    			if (tn.left!=null)	addOn.add(tn.left);
    			addOn.add(tn);
    			if (tn.right!=null)	addOn.add(tn.right);
    			
    			expandList(thisLevel, addOn, i);
    		}
 
    	}

    	for (TreeNode node : thisLevel){
    		res.add(node.val);
    	}
    	
        return res;
    }
	
    
    public void expandList(List<TreeNode> original, List<TreeNode> addon, int pos){
    	
    	List<TreeNode> res = new ArrayList<TreeNode>(original.size() + addon.size()-1);
    	
    	res.addAll(original.subList(0, pos));
    	res.addAll(addon);
    	res.addAll(original.subList(pos+1, original.size()));
    }
}
