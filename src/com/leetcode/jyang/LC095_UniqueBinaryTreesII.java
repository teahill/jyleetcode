package com.leetcode.jyang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * 
 * Given n = 2, there are a total of 2 unique BST's.
 * 
 * 1          2
 *  \        /
 *   2      1  
 * 
 * 
 * Given n = 3, there are a total of 5 unique BST's.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * 
 * @author jyang
 *
 */

public class LC095_UniqueBinaryTreesII {

    public List<TreeNode> generateTrees(int n) {
    	
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	
    	if (n<=0) {
    		res.add(null);
    		return res;
    	}
    	
    	int[] nums = new int[n];
    	
    	for (int i=0; i<n; i++){
    		nums[i] = i+1;
    	}
    	
    	return generateTreesDP(nums);
    }
	
    
    public List<TreeNode> generateTreesDP(int[] nums){
    	
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	
    	if (nums.length==0){
    		return res;
    	}
    	
       	if (nums.length==1){	
       		res.add(new TreeNode(nums[0]));
       		return res;
       	}
    	
       	for (int j=0; j<nums.length; j++){
    		
    		int[] left = Arrays.copyOfRange(nums, 0, j);
    		int[] right = Arrays.copyOfRange(nums, j+1, nums.length);
    		
    		List<TreeNode> lRes = generateTreesDP(left);
    		List<TreeNode> rRes = generateTreesDP(right);
    		
       		if (lRes.isEmpty() && rRes.isEmpty()){
    			TreeNode root = new TreeNode(nums[j]);
				res.add(root);
    		}
    		else if (lRes.isEmpty()){
       			for (TreeNode rn : rRes) {
    				TreeNode root = new TreeNode(nums[j]);
    				root.right = rn;
    				res.add(root);
    			}
    		}
       		else if (rRes.isEmpty()){
       			for (TreeNode ln : lRes) {
    				TreeNode root = new TreeNode(nums[j]);
    				root.left = ln;
    				res.add(root);
    			}
    		}
       		else {
	    		for (TreeNode ln : lRes) {
	    			for (TreeNode rn : rRes) {
	    				
	    				TreeNode root = new TreeNode(nums[j]);
	    				root.left = ln;
	    				root.right = rn;
	    				
	    				res.add(root);
	    			}
	    		}
       		}
    	}
    	
        return res;
    }
    
}
