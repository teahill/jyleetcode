package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 *   1
 *    \
 *     2
 *    /
 *   3
 * return [1,2,3].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 
 * @author jyang
 *
 */

public class LC144_PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
    	
    	List<Integer> res = new ArrayList<Integer>(); 	
    	if (root==null)		return res;
    	
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	
    	st.push(root);
    	
    	while (!st.isEmpty()){
    		TreeNode node = st.pop();
       		res.add(node.val);
    		if (node.right!=null)	st.push(node.right);
    		if (node.left!=null)	st.push(node.left);
    	}
	
    	//preorderTraversalDfs(root, res);
    	
        return res;
    }
    
    public void preorderTraversalDfs(TreeNode root, List<Integer> res) {
    	
    	if (root==null)		return;
    	
    	res.add(root.val);	
    	preorderTraversalDfs(root.left, res);
    	preorderTraversalDfs(root.right, res);   
    }
    
	
}
