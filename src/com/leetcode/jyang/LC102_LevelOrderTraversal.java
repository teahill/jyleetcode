package com.leetcode.jyang;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC102_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
     
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
    	
    	if (root==null)	return res;
    	
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            List<Integer> level = new LinkedList<Integer>();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	continue;
                }                
                
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                else {
                	nextLevel.add(null);
                }
                
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                else {
                	nextLevel.add(null);
                }
                
                level.add(currentNode.val);
            }
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            
            if (!level.isEmpty())
            	res.add(level);
        }
        
        return res;
    }
	
}
