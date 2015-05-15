package com.leetcode.jyang;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class LeetCodeUtils {
	
	public static TreeNode buildBalancedBST(int[] num){
		
		if (num.length==0)	return null;
		
		TreeNode root = new TreeNode(num[0]);
		
		for (int i=1; i<num.length; i++){
			insertBST(root, num[i]);
		}
		
		return root;
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
		
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		
		queue.add(root);
		
		while (!queue.isEmpty()){
			
			TreeNode node = queue.poll();
			
			sb.append(node.val + ",");
			
			if (node.left!=null){
				queue.add(node.left);
			}
			else {
				sb.append("#,");
			}
			
			if (node.right!=null){
				queue.add(node.right);
			}
			else {
				sb.append("#,");
			}
		}
		
		return sb.toString();
	}
	
	public static TreeNode deserilizeBinaryTree(String tree){
		
		String[] nodes = tree.split(",");
		
		if (nodes.length==0){
			return null;
		}
		
		TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
		
		int level = 1;
		
		
		for (int i=1; i<nodes.length; i++){
			
			//TreeNode parent = new TreeNode(nodes[i]);
			
			
			
		}
		
		
		
		
		return root;
	}
	
	public static ListNode buildList(int[] input){
		
		if (input==null || input.length==0){
			return null;
		}
		
		ListNode head = new ListNode(input[0]);
		ListNode ptr = head;
		
		for (int i=1; i<input.length; i++){
			
			ListNode node = new ListNode(input[i]);
			ptr.next = node;
			ptr = node;
		}
		
		return head;
	}
	
	public static void printlist(ListNode head){
		
		if (head==null){
			System.out.println("List is null");
		}
		
		ListNode ptr = head;
		
		while (ptr!=null){
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}
	
	public static ListNode findTail(ListNode head){
		
		if (head==null){
			return null;
		}
		
		ListNode ptr = head;
		
		while (ptr.next!=null){
			ptr = ptr.next;
		}
		
		return ptr;
	}
	
	public static void printIntArray(int[] a){
		for (int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void printIntArray2D(int[][] a){
		for (int i = 0; i<a.length; i++) {
			for (int j = 0; j<a.length; j++){
				System.out.print(a[i][j] + " ");				
			}
			System.out.println();
		}
	}	

	public static void printStack(Stack<?> s){
		
		Iterator<?> itr = s.iterator();
		
		while (itr.hasNext()){
			System.out.print(itr.next() + "->");
		}
		System.out.println();
	}
	
	public static void printStrArray(String[] a){
		for (int i = 0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	public static void printList(List<?> list){
		System.out.print("[");
		for (Object s : list){
			System.out.print(s + " ");
		}	
		System.out.println("]");
	}
	
	public static int factorial(int n){
		
		if (n<=0)	return 0;
		if (n==1)	return 1;
		
		int prev = 1;
		for (int i=1; i<=n; i++){
			prev = prev*i;
		}
		
		return prev;
	}
}
