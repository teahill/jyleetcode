package com.leetcode.jyang;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * 
 * @author jyang
 *
 */

public class LC142_LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
    	
    	if (head==null || head.next==null){
    		return null;
    	}
    	
       	if (head.next==head){ 
    		return null;
    	}   
       	
       	if (head.next.next == head){
       		return head;
       	}
       	
    	ListNode pSlow = head;
    	ListNode pFast = head;
 
        while (pFast !=null && pSlow!=null){
        	
        	if (pFast==pSlow && pFast!=head){
        		break;
        	}
        	
        	pFast = pFast.next;
        	if (pFast!=null){
        		pFast = pFast.next;
        	}
        
        	pSlow = pSlow.next;
        }
        
        if (pFast==null){
        	return null;
        }
        
        pSlow = head;
        
        while (true){
        	
        	if (pSlow==pFast){
        		return pSlow;
        	}
        	
        	pSlow = pSlow.next;
        	pFast = pFast.next;        	
        }
    }	
}
