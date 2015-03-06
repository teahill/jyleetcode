package com.leetcode.jyang;

/**
 * Level: Easy
 *  
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * 
 * @author jyang
 *
 */

public class LC019_RemoveNthNode {

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	
    	ListNode ptr1 = head;
    	ListNode ptr2 = head;
    	
    	int count = 0;
    	
    	while (ptr1.next!=null){
    		
    		ptr1 = ptr1.next;
    		count++;
    		
    		if (count>n){
    			ptr2 = ptr2.next;
    		}
    	}
    	
    	if (count<n-1){
    		return head;
    	}
    	else if (count<n){
    		return head.next;
    	}
    	else {
    		ptr2.next = ptr2.next.next;
    		return head;
    	}
    }
	
}
