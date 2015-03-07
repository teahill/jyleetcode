package com.leetcode.jyang;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * 
 * 
 * @author jyang
 *
 */
public class LC021_MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		ListNode head = new ListNode(0);
		
		if (l1==null && l2==null){
			return null;
		}
		else if (l1==null) {
			return l2;
		}
		else if (l2==null){
			return l1;
		}
		
		ListNode p1 = l1;
		ListNode p2 = l2;
		
		ListNode ptr = head;
		
		while (true){
			
			ListNode newNode  = null;
			
			if (p1!=null && p2!=null){
				
				if (p1.val <= p2.val){
					newNode = p1;
					p1 = p1.next;
				}
				else {
					newNode = p2;
					p2 = p2.next;
				}
			}
			else if (p1==null && p2!=null){
				newNode = p2;
				p2 = p2.next;
			}
			else if (p1!=null && p2==null){
				newNode = p1;
				p1 = p1.next;
			}
			else {
				break;
			}
			
			ptr.next = newNode;
			ptr = ptr.next;

		}
		
	    return head.next;    
	}
	
}
