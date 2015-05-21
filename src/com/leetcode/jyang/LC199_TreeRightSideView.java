package com.leetcode.jyang;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 * 
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * 
 * You should return [1, 3, 4].
 * 
 * 
 * @author jyang
 *
 */

public class LC199_TreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
    	
    	List<Integer> res = new LinkedList<Integer>();
    	
    	if (root==null)		return res;
        
        List<TreeNode> currentLevel = new LinkedList<TreeNode>();
        List<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;

        while (!currentLevel.isEmpty()) {
        	
        	TreeNode rightMost = null;
        	for (int i=currentLevel.size()-1; i>=0; i--){
        		if (currentLevel.get(i)!=null){
        			rightMost = currentLevel.get(i);
        			break;
        		}        			
        	}

        	res.add(rightMost.val);
        	
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
        }
        
        return res;
    }
    
}
