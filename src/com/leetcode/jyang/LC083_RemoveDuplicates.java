package com.leetcode.jyang;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * 
 * @author jyang
 *
 */
public class LC083_RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
    	
    	if (head==null){
    		return head;
    	}
    	
    	ListNode ptr = head;
    	
    	while (ptr.next!=null){
    		
    		if (ptr.val == ptr.next.val){	
    			ptr.next = ptr.next.next;
    		}
    		else {
    			ptr = ptr.next;
    		}  		
    	}
        
    	return head;
    }
	
}
