package com.leetcode.jyang;

import java.util.Arrays;

/**
 * 
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @author jyang
 *
 */

public class LC108_SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        
		if (nums.length==0)	return null;	
		
		return buildBalancedBST(nums, 0, nums.length-1);

    }
    
	public static TreeNode buildBalancedBST(int[] num, int start, int end){
		
		if (start > end){
			return null;
		}
		
		int mid = start + (end - start)/2;
		TreeNode parent = new TreeNode(num[mid]);
		
		parent.left = buildBalancedBST(num, start, mid-1);;
		parent.right = buildBalancedBST(num, mid+1, end);;
		
		return parent;
	}
	
}
