package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 * 
 * @author jyang
 *
 */

public class LC103_ZigzagLevelTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	
    	if (root==null)		return res;
        
        List<TreeNode> currentLevel = new LinkedList<TreeNode>();
        List<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;
        // zig is defined as going from left to right, zag is the reverse.
        boolean zig = true;

        while (!currentLevel.isEmpty()) {        	
        	
       		List<Integer> level = buildList(currentLevel, zig);
         	
       		if (!level.isEmpty())
       			res.add(level);
       		
        	for (TreeNode tn : currentLevel){
                if (tn==null){
                	continue;
                }
                
                if (tn.left != null) {
                    nextLevel.add(tn.left);
                    nullLevel = false;
                }
                else {
                	nextLevel.add(null);
                }
                
                if (tn.right != null) {
                    nextLevel.add(tn.right);
                    nullLevel = false;
                }
                else {
                	nextLevel.add(null);
                }
        	}
            
            if (nullLevel)
            	break;
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            nullLevel = true;
            
            zig = !zig;
        }
        
        return res;
    	
    }
	
    public List<Integer> buildList(List<TreeNode> nodes, boolean zig){
    	
    	List<Integer> res = new ArrayList<Integer>(nodes.size());
    	
   		for (TreeNode t : nodes){
   			
   			if (t==null)	continue;
   			
   			if (zig)
   				res.add(t.val);
   			else 
   				res.add(0, t.val);
   		}

   		return res;
    }
}
