package com.leetcode.jyang;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * 
 * @author jyang
 * 
 * https://leetcode.com/discuss/25580/simple-java-solution-with-clear-explanation
 *
 */

public class LC092_ReverseLinkedListII {
	
	public void reverse(ListNode head, int m, int n){
		
		if (head==null || head.next==null || m==n)	return;
		
		ListNode start = head;
		ListNode sprev = head;
		ListNode end = head;
		
		ListNode curr = head;
		ListNode prev = head;
		
		int count = 1;
		
		while (curr!=null){
			
			if (count==m){
				start = curr;
				sprev = prev;
			}
			
			if (count==n){
				end = curr;
				break;
			}
			
			prev = curr;
			curr = curr.next;	
			
			count++;
		}
		
		ListNode p1 = start;;
		ListNode p2 = start.next;		
		ListNode tmp = p2.next;
		
		
		while (true){
			
	  		p2.next = p1;
    		p1 = p2;
    		p2 = tmp;
    		
    		if (p2!=end)
    			tmp = p2.next;
    		else
    			break;
		}
		
		prev.next = p2;
		start.next = tmp;
	}
}
