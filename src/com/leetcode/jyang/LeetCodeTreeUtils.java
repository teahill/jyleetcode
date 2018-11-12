package com.leetcode.jyang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class LeetCodeTreeUtils {

	public static TreeNode generateBST(int size, int maxVal){
		
		return generateBST(size, maxVal, 0);
	}
	
	public static TreeNode generateBST(int size, int maxVal, int offset) {
		
		if (maxVal < size){
			maxVal = size*2;
		}
		
		Random ran = new Random();
			
		List<Integer> list = new ArrayList<Integer>();
		
		while (list.size() <= size){
			int i = ran.nextInt(maxVal) - offset;
			if (!list.contains(i)){
				list.add(i);
			}
		}
				
		int[] num = new int[size];
		for (int i=0; i<size; i++){
			num[i] = list.get(i);
		}
		
		return buildBalancedBST(num);
	}
	
	public static TreeNode buildBalancedBST(int[] num){
		
		if (num.length==0)	return null;
		
		Arrays.sort(num);
		
		TreeNode root = buildBalancedBST(num, 0, num.length-1);
		
//		TreeNode root = new TreeNode(num[0]);
//		
//		for (int i=1; i<num.length; i++){
//			insertBST(root, num[i]);
//		}
		
		return root;
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
	
	public static void printTreeByLevel(TreeNode root) {

        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	System.out.print("# ");
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
                
                System.out.print(currentNode.val + " ");
            }
            System.out.println();
            
            if (nullLevel)
            	break;
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            nullLevel = true;
        }
    }
	
	public static void insertBST(TreeNode root, int n){
		
		if (n < root.val) {
			if (root.left==null){
				TreeNode node = new TreeNode(n);
				root.left = node;
			}
			else {
				insertBST(root.left, n);
			}
		}
		else if (n > root.val){
			if (root.right==null){
				TreeNode node = new TreeNode(n);
				root.right = node;
			}
			else {
				insertBST(root.right, n);
			}
		}
		else {
			;
		}	
	}
	
	public static void printTreeInOrder(TreeNode root){
		if (root==null){
			return;
		}
		
		printTreeInOrder(root.left);
		System.out.print(root.val + " ");
		printTreeInOrder(root.right);
	}
	
	public static void printTreePostOrder(TreeNode root){
		if (root==null){
			return;
		}

		printTreePostOrder(root.left);
		printTreePostOrder(root.right);
		System.out.print(root.val + " ");
	}
	
	public static void printTreePreOrder(TreeNode root){
		if (root==null){
			return;
		}
		
		System.out.print(root.val + " ");
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}
	
	public static void printTreeLevelOrder(TreeNode root){
		if (root==null){
			return;
		}
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		
		queue.add(root);
		
		while (!queue.isEmpty()){
			
			TreeNode node = queue.poll();
			
			System.out.print(node.val + " ");
			
			if (node.left!=null){
				queue.add(node.left);
			}
			
			if (node.right!=null){
				queue.add(node.right);
			}
		}
		
		System.out.println();
	}
	
	public static String serilizeBinaryTree(TreeNode root){
		
		if (root==null){
			return "";
		}
		
		StringBuilder sb = new StringBuilder();
		
        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);
        
        boolean nullLevel = true;

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	sb.append("#,");
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
                
                sb.append(currentNode.val + ",");
            }
            
            if (nullLevel)
            	break;
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
            nullLevel = true;
        }
		
		return sb.toString();
	}
	
	public static TreeNode deserilizeBinaryTree(String tree){
			
		String[] nodes = tree.split(",");
		
		if (nodes.length==0){
			return null;
		}
			
		Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>(); 
		
		TreeNode root = null;
		int leavesSoFar = 0;
		
		for (int i=0; i<nodes.length; i++){
			
			if (nodes[i].equals("#") || nodes[i].equals("")){
				leavesSoFar++;
				continue;
			}
			
			int val = Integer.valueOf(nodes[i]);		
			TreeNode parent = map.get(i);
			if (parent == null){
				parent = new TreeNode(val);
				map.put(i, parent);
			}
						
			if (i==0)	root = parent;
			
			int leftIdx = (i+1)*2-1 - leavesSoFar*2;
			if (leftIdx > nodes.length -1)	break;
			
			int rightIdx = (i+1)*2 - leavesSoFar*2;
			if (rightIdx > nodes.length -1)	break;
			
			TreeNode left = null;
			String leftStr = nodes[leftIdx];
			if (!leftStr.equals("#")){
				left = map.get(leftIdx);
				if (left==null){
					int leftVal = Integer.valueOf(leftStr);
					left = new TreeNode(leftVal);
					map.put(leftIdx, left);
				}
			}
			
			TreeNode right = null;
			String rightStr = nodes[rightIdx];
			if (!rightStr.equals("#")){
				right = map.get(rightIdx);
				if (right==null){
					int rightVal = Integer.valueOf(rightStr);
					right = new TreeNode(rightVal);
					map.put(rightIdx, right);
				}
			}
						
			parent.left = left;
			parent.right = right;
		}
		
		return root;
	}
	
	public static void printTreeByLevel2(TreeNode root) {

        Queue<TreeNode> currentLevel = new LinkedList<TreeNode>();
        Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<TreeNode> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                TreeNode currentNode = iter.next();
                
                if (currentNode==null){
                	System.out.print("# ");
                	continue;
                }                
                
                if (currentNode.left != null) {
                    nextLevel.add(currentNode.left);
                }
                
                if (currentNode.right != null) {
                    nextLevel.add(currentNode.right);
                }
                
                System.out.print(currentNode.val + " ");
            }
            System.out.println();
            
            currentLevel = nextLevel;
            nextLevel = new LinkedList<TreeNode>();
        }
    }
	
	public static void printTreeLevelSums(TreeNode root) {
		
		
	}
}
