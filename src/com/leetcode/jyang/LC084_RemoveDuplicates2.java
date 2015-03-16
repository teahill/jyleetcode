package com.leetcode.jyang;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 *
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 *  
 * 1 1 1 2 2 2 3 3 4 5 5 5 6 7 8 8 9 9 9
 * 
 * @author jyang
 *
 */
public class LC084_RemoveDuplicates2 {
	
	public ListNode deleteDuplicates(ListNode head) {
		
	    if(head==null || head.next==null)
	        return head;
		
	    ListNode dummy = new ListNode(0);
	    dummy.next=head;
	        
	    ListNode prev = dummy; 
		ListNode ptr = head;
		
		while (ptr!=null){
			
			if (ptr.next!=null && ptr.val==ptr.next.val){
				
				ListNode tmp = ptr;
				
				while (tmp!=null && ptr.val==tmp.val){
					tmp = tmp.next;
				}
				
				ptr = tmp;
				prev.next = ptr;
			}
			else {
				prev = prev.next;
				ptr = ptr.next;
			}
		}
		
		return dummy.next;
	}
	
	public ListNode deleteDuplicates2(ListNode head) {
		
        if(head==null || head.next==null)
        	return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        
        ListNode prev = dummy; 
        ListNode curr = head;
        	        
        int count=0;
        
        while(curr!=null){	
        	
            if(curr.val==prev.next.val){
                count++;
                curr = curr.next;
            }
            else {
                if(count>1){
                    prev.next=curr;
                }
                else{
                    prev=prev.next;
                    curr=prev.next;
                }
                count=0;
            }
        }

        if(count>1)
        {
            prev.next=curr;
        }
        
        return dummy.next;
    }

}
