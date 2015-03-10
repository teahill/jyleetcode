package com.leetcode.jyang;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * 
 * 
 */

public class LC025_ReverseKGroup {
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
		int count = 0;
		
		ListNode ptr = head;
		
		while (ptr!=null) {
			count++;
			ptr = ptr.next;
		}
		
		if (count<k){
			return head;
		}
		
	    return null;
	}
	
	public ListNode reverseList(ListNode head){
		
		if (head==null){
			return head;
		}
		
		ListNode p1 = head;
		ListNode p2 = head.next;
		ListNode newHead = p2;
		
		while (p1!=null && p2!=null){
			
			ListNode tmp = p2.next;
			p2.next = p1;
			p1.next = tmp;
			
			p2 = p1.next;
			
			System.out.print("->");
			LeetCodeUtils.printlist(p1);
			
			System.out.print("-->");
			LeetCodeUtils.printlist(p2);

			System.out.print("--->");
			LeetCodeUtils.printlist(newHead);
		}
		
		return newHead;
		
	}
}
