package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    		
    		nextLevel = expandList(thisLevel, processed);
    		
    		if (nextLevel.size()==thisLevel.size()){
    			break;
    		}
    		else {
    			thisLevel = nextLevel;
    		} 
    	}

    	for (TreeNode node : thisLevel){
    		res.add(node.val);
    	}
    	
        return res;
    }
	
    
    public List<TreeNode> expandList(List<TreeNode> original, Set<TreeNode> processed){
    	
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	
    	for (TreeNode tn : original){
    		
    		List<TreeNode> triple = new ArrayList<TreeNode>();
    		
    		if (tn.left!=null && !processed.contains(tn)){
    			triple.add(tn.left);
    		}
    		
   			triple.add(tn);
 
    		if (tn.right!=null && !processed.contains(tn)){
    			triple.add(tn.right);
    		}    			 
    		
    		res.addAll(triple);
    		processed.add(tn);
    	}
    	
    	return res;
    }
}
