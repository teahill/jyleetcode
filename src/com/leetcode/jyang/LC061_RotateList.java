package com.leetcode.jyang;

/**
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * 
 * @author jyang
 *
 */

public class LC061_RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        
    	if (head==null){
    		return head;
    	}
    	
    	ListNode p1 = head;
    	ListNode p2 = head;
    	ListNode prev = head;    	
    	
    	int cnt = 0;
    	
    	while (p1!=null){
    		
    		prev = p1;
    		p1 = p1.next;
    		
    		if (cnt>k){
    			p2 = p2.next;
    		}
    		
    		cnt++;
    	}
    	
    	if (k%cnt==0){
    		return head;
    	}
    	
    	if (cnt<k){	
    		k = k%cnt;
    		
	    	p1 = head;
	    	p2 = head;
	    	prev = head;
	    	
	    	cnt = 0;
	    	
	    	while (p1!=null){    		
	    		prev = p1;
	    		p1 = p1.next;
	    		
	    		if (cnt>k){
	    			p2 = p2.next;
	    		}
	    		
	    		cnt++;
	    	}
    	}
    	
    	prev.next = head;
    	
    	ListNode newHead = p2.next;
    	p2.next = null;
    	
    	return newHead;
    }	
	
}
