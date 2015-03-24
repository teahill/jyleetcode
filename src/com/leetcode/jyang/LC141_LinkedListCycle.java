package com.leetcode.jyang;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * 
 * @author jyang
 *
 */

public class LC141_LinkedListCycle {

    public boolean hasCycle(ListNode head) {
    	
    	if (head==null || head.next==null){
    		return false;
    	}
    	
       	if (head.next==head || head.next.next == head){
    		return true;
    	}   	
    	
    	ListNode p1 = head;
    	ListNode p2 = head;
    	
    	while (p1!=null && p2!=null){
    		
    		if (p2==p1 && p1!=head){
    			return true;
    		}
    		
    		p1 = p1.next;
    		
    		p2 = p2.next;
    		if (p2!=null){
    			p2 = p2.next;
    		}
    	}
    	
    	return false;   
    }
	
}
