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
		
		if (head==null || head.next==null){
			return head;
		}
		
		// new head at the moment. It is a moving head until the entire reverse is done
		ListNode newHead = head.next;
		// next node to be placed before current newHead (and becomes the new newHead)
		ListNode ptr = newHead.next;
		
		newHead.next = head;
		head.next = null; // it will eventually become the tail
		
		while (ptr!=null){
			
			ListNode tmp = ptr.next;
			
			ptr.next = newHead;
			newHead = ptr;
			ptr = tmp;
		}
		
		return newHead;
	}
	
	public ListNode reverseList(ListNode head, int k){
		
		if (head==null || head.next==null){
			return head;
		}
		
		ListNode[] a = new ListNode[k];
		
		ListNode p1 = head;
		
		ListNode localHead = null;
		ListNode localTail = null;
		
		ListNode finalHead = null;
		
		while (p1!=null){
			
			int i = 0;
			
			while (i<k && p1!=null){			
				a[i] = p1;
				p1 = p1.next;
				
				i++;
			}
			
			if (i==k){
				
				for (int j=k-1; j>0; j--){
					a[j].next = a[j-1];
				}
				
				if (localTail!=null){
					localTail.next = a[k-1];
				}
				
				localHead = a[k-1];
				localTail = a[0];
				
				if (finalHead==null){
					finalHead = localHead;
				}
				
				localTail.next = p1;
			}
			else {
				if (localHead==null){
					return head;
				}
			}
		}
		
		return finalHead;
	}
}
