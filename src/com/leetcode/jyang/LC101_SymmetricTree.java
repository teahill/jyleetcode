package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 * But the following is not:
 *    1
 *   / \
 *  2   2
 *   \   \
 *    3   3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC101_SymmetricTree {
	
    public boolean isSymmetric(TreeNode root) {
        
		if (root==null){
			return true;
		}
			
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;

        while (!currentLevel.isEmpty()) {
            
        	Iterator<TreeNode> iter = currentLevel.iterator();
    		List<String> level = new ArrayList<String>();
            
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	level.add("#");
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
                
                level.add(currentNode.val + "");
            }
            
            //LeetCodeUtils.printList(level);
            
            if (!isSymmetric(level)){
            	return false;
            }
            
            if (nullLevel)
            	break;
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            nullLevel = true;
        }
		
		return true;
    }
	
    public boolean isSymmetric(List<String> list){
    	
    	int size = list.size();
    	
    	if (size<=1){
    		return true;
    	}
    	
    	if (size%2!=0)	return false;
    	
    	int i = size/2 -1;
    	int j = size/2;
    	
    	while (i>=0 && j<=size-1){
    		
    		if (!list.get(i).equals(list.get(j))){
    			return false;
    		}
    		
    		i--;
    		j++;
    	}
    	
    	return true;
    }
}
