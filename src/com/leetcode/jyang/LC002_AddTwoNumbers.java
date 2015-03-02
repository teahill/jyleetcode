package com.leetcode.jyang;

/**
 * LEVEL: MEDIUM
 * 
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * 
 * NOTE: although this passed Leetcode's OJ, it is not a complete solution, in that if the input numbers are 
 * larger than what a long can handle, you will see an overflow. The real solution is not to use the whole
 * inputs to do the addition, instead do it at single digit level, of course the logic will be significantly
 * more complicated because of the carry overs resulted from additions.
 * 
 * @author jyang
 *
 */

public class LC002_AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		long n1 = getNumber(l1);
		long n2 = getNumber(l2);
		
		long sum = n1 + n2;
		String sumStr = "" + sum;
		
		int len = sumStr.length();
		
		if (len==0){
			return null;
		}
		
		ListNode head = new ListNode(sumStr.charAt(len-1)-48);
		ListNode ptr = head;
		
		if (len==1){
			return head;
		}
		
		for (int i = sumStr.length()-2; i>=0; i--){
			
			char c = sumStr.charAt(i);
			ListNode n = new ListNode(c-48);
			
			ptr.next = n;
			ptr = n;		
		}
		
	    return head;    
	}
	
	public ListNode buildList(int[] input){
		
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
	
	public void printlist(ListNode head){
		
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
	
	public long getNumber(ListNode head){
		
		if (head==null){
			return -1;
		}
		
		ListNode ptr = head;
		
		String str = "";
		
		while (ptr!=null){
			str = ptr.val + str;
			ptr = ptr.next;
		}
		
		return Long.parseLong(str);
	}
	
	public static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) {
	        val = x;
	        next = null;
	    }
	}
	
	public static void main(String[] args){
		
		int[] list1 = new int[]{1,9,9,9,9,9,9,9,9,9};
		
		int[] list2 = new int[]{9};
		
		LC002_AddTwoNumbers atn = new LC002_AddTwoNumbers();
		
		ListNode nodelist1 = atn.buildList(list1);
		
		ListNode nodelist2 = atn.buildList(list2);
		
		atn.printlist(nodelist1);
		System.out.println("List 1 as an interger: " + atn.getNumber(nodelist1));
		
		atn.printlist(nodelist2);
		System.out.println("List 2 as an interger: " + atn.getNumber(nodelist2));
		
		ListNode result = atn.addTwoNumbers(nodelist1, nodelist2);
		
		atn.printlist(result);
	}
}
