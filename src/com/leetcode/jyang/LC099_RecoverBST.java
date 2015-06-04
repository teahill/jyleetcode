package com.leetcode.jyang;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 *
 * Recover the tree without changing its structure.
 * 
 * Note:
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space
 * solution?
 * 
 * 
 * @author jyang
 *
 */

public class LC099_RecoverBST {
	
	private TreeNode n1 = null;
	private TreeNode n2 = null;
	
	TreeNode prev = new TreeNode(Integer.MIN_VALUE);
	
	/*
	 *                   5 
	 *             
	 *            1             11 
     *       
     *         0     3(7)     6      15 
     *       
     *      #   #  #   4   #  (3)7  #   17 
	 * 
	 * 
	 */
	
	public void recoverTree(TreeNode root) {
		
		if (root==null)		return;
		if (root.left==null && root.right==null)	return;
		
		inorder(root);
		
		if (n1!=null && n2!=null){
			swap(n1, n2);
		}
		
		// TODO
		else if (n2==null){
			if (root.left!=null && root.val < root.left.val){
				swap(root, root.left);
			}
			if (root.right!=null && root.val > root.right.val){
				swap(root, root.right);
			}
		}
	}
	
	public void inorder(TreeNode root) {
		
		if (root==null){
			return;
		}
		
		inorder(root.left);
		
		if (prev.val >= root.val){
			if (n1==null){
				// first anomaly happens when something is too large, so pick the larger one
				n1 = prev;
			}
			else {
				// first anomaly happens when something is too small, so pick the smaller one
				n2 = root;
			}	
		}
		
		prev = root;

		inorder(root.right);
	}
	
	private void swap(TreeNode n1, TreeNode n2) {
		int tmp = n1.val;
		n1.val = n2.val;
		n2.val = tmp;
	}
	
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    // The reason for this initialization is to avoid null pointer exception in the first comparison when prevElement has not been initialized
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree2(TreeNode root) {

        // In order traversal to find the two elements
        traverse(root);

        // Swap the values of the two nodes
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        // Start of "do some business", 
        // If first element has not been found, assign it to prevElement (refer to 6 in the example above)
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        // If first element is found, assign the second element to the root (refer to 2 in the example above)
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }        
        prevElement = root;

        // End of "do some business"

        traverse(root.right);
    }
}
