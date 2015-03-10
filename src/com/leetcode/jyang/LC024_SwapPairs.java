package com.leetcode.jyang;

/**
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes
 * itself can be changed.
 * 
 * 
 * @author jyang
 *
 */

public class LC024_SwapPairs {
	
    public ListNode swapPairs(ListNode head) {
    	
    	if (head==null || head.next==null){
    		return head;
    	}
        
    	// First 2 nodes swapped
    	ListNode tmp = head.next.next;
    	ListNode newHead = head.next;
    	newHead.next = head;
    	head.next = tmp;
    	  	
       	ListNode p0 = newHead.next;
       			
    	// 3rd and 4th
    	ListNode p1 = newHead.next.next;
    	if (p1==null){
    		return newHead;
    	}
    	
    	ListNode p2 = p1.next;
    	if (p2==null) {
    		return newHead;
    	}
    	  	
    	while (p1!=null && p2!=null){
    		// 3 pointers to change
    		p0.next = p2;
    		p1.next = p2.next;
    		p2.next = p1;
    		
    		p0 = p1;
    		p1 = p1.next;
    		if (p1!=null){
    			p2 = p1.next;
    		}
    	}
 
    	return newHead;
    }
}
