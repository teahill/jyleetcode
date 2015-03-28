package com.leetcode.jyang;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class LeetCodeUtils {
	
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
}
