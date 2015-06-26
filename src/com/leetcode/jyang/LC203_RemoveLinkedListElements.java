package com.leetcode.jyang;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * 
 * @author jyang
 *
 */

public class LC203_RemoveLinkedListElements {
	
    public ListNode removeElements(ListNode head, int val) {
    	
    	if (head==null)		return head;
    	
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	
    	ListNode p1 = dummy;
    	ListNode p2 = dummy.next;
    	
    	while (p1!=null && p2!=null){
    		if (p2.val == val){
    			p2 = p2.next;
    			p1.next = p2;
    		}
    		else {
    			p1 = p2;
    			p2 = p2.next;
    		}
    	}
    	
    	return dummy.next;
    }

}
