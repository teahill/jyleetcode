package com.leetcode.jyang;

/**
 * Reverse a singly linked list.
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 * 
 * 
 * 
 * @author jyang
 *
 */

public class LC206_ReverseLinkedList {
	
	// iterative
    public ListNode reverseList(ListNode head) {
    	
    	if (head==null || head.next==null) 	return head;
    	
    	ListNode p1 = head;	
    	ListNode p2 = head.next;
    	ListNode tmp = p2.next;
    	
    	head.next = null;
    	
    	while (p2!=null){
    		p2.next = p1;
    		p1 = p2;
    		p2 = tmp;
    		
    		if (p2!=null)
    			tmp = p2.next;
    	}
    
    	return p1;
    }

    // recursive
    public ListNode reverseList2(ListNode head) {
    	
    	if (head==null || head.next==null) 	return head;
    	
    	ListNode tmp = head.next;
    	
    	ListNode newHead = reverseList2(head.next);
    	
    	tmp.next = head;
    	head.next = null;
    	
    	return newHead;
    	
    }
}
