package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *              5
 *             / \
 *            4   8
 *           /   / \
 *          11  13  4
 *         /  \    / \
 *        7    2  5   1
 * return
 * [
 *  [3 4 11 2 ]
 *  [3 8 9 ]
 *  [3 8 4 5 ] 
 * ]
 * 
 * @author jyang
 *
 * @alsosee https://leetcode.com/discuss/35201/simple-dfs-java-solution
 *
 */

public class LC113_PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();	
    	if (root==null)		return res;
    	  	
    	// stack seems to be a better choice here
    	List<Integer> path = new ArrayList<Integer>();	
    	pathSumBT(root, sum, res, path);
    	
    	return res;
    }
	
    public void pathSumBT(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
    	
    	path.add(root.val);
 
    	if (root.left==null && root.right==null && root.val==sum){
    		res.add(new ArrayList<Integer>(path));
    	}
    	
    	if (root.left!=null) {
    		pathSumBT(root.left, sum - root.val, res, path);
    	}
    	if (root.right!=null) {
    		pathSumBT(root.right, sum - root.val, res, path);
    	}
    	
    	path.remove(path.size()-1);
    }
    
    public void pathSumBT2(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path){
    	
    	if (root==null)		return;
    	
    	if (root.left==null && root.right==null && root.val==sum){
    		List<Integer> tmp = new ArrayList<Integer>(path);
    		tmp.add(root.val);
    		res.add(tmp);
    	}
    	
    	path.add(root.val);
    	pathSumBT(root.left, sum - root.val, res, path);
    	pathSumBT(root.right, sum - root.val, res, path);
    	path.remove(path.size()-1);
    }
}
