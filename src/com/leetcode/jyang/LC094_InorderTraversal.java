package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    	
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	
 //   	TreeNode node = root;
    	
    	if (root.right!=null) st.push(root.right);
    	st.push(root);
    	if (root.left!=null) st.push(root.left);
    	
//    	while (true){
//    		
//    		Iterator<TreeNode> itr = st.iterator();
//    		
//    		Stack<TreeNode> st2 = new Stack<TreeNode>();
//    		
//    		while (itr.hasNext()){
//    			TreeNode node = itr.next();
//    			
//    			if (node.right!=null)	st2.push(node.right);
//    			st2.push(node);
//    			if (node.right!=null)	st2.push(node.right);
//    		}
//    		
//    		
//    		
//    	}
    	
    	
//    	do {
//    		if (node.right!=null)	st.push(node.right);
//    		if (node==root)	st.push(node);
//       		if (node.left!=null)	st.push(node.left);
// 
//       		node = st.pop();
//       		res.add(node.val);
//       		
//    	} while (!st.isEmpty());

        return res;
    }
	
}
