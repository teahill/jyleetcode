package com.leetcode.jyang;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop
 * from front, size, and is empty operations are valid.
 * 
 * Depending on your language, queue may not be supported natively. You may simulate a queue by
 * using a list or deque (double-ended queue), as long as you use only standard operations of a
 * queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be
 * called on an empty stack).
 * 
 * 
 * @author jyang
 * 
 * Note that the Deque interface supports both FIFO (queue) and FILO (stack) behavior, and it is 
 * preferred means over the Stack class because more encapsulation (Stack extends Vector, and it 
 * is not implementing any interface), and faster, and thread safe (?).
 * 
 * Interface wise: queue behavior: offer, poll
 * 				   stack behavior: push, pop
 *
 */

public class LC225_QueueStack {
	
	Deque<Integer> q1 = new ArrayDeque<Integer>();
	Deque<Integer> q2 = new ArrayDeque<Integer>();
	
    // Push element x onto stack.
    public void push(int x) {
    	
    	if (q1.isEmpty() && q2.isEmpty()){
    		q1.push(x);
    	}
    	else {
    		// at any time there is at least an empty queue
    		Deque<Integer> emptyQ = q1.isEmpty() ? q1 : q2;
    		Deque<Integer> usedQ = q1.isEmpty() ? q2 : q1;
    		
    		emptyQ.offer(x);
    		
    		while (!usedQ.isEmpty()){
    			emptyQ.offer(usedQ.poll());
    		}
    	}
    }

    // Removes the element on top of the stack.
    public void pop() {
    	Deque<Integer> usedQ = q1.isEmpty() ? q2 : q1;
    	usedQ.poll(); 
    }

    // Get the top element.
    public int top() {
    	Deque<Integer> usedQ = q1.isEmpty() ? q2 : q1;
    	return usedQ.peek(); 
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
    
//    Queue<Integer> q = new LinkedList<Integer>();
//    // Push element x onto stack.
//    public void push(int x) {
//        q.add(x);
//        for (int i = 0; i < q.size() - 1; i++) {
//            q.add(q.remove());    
//        }
//    }
//
//    // Removes the element on top of the stack.
//    public void pop() {
//        q.remove();
//    }
//
//    // Get the top element.
//    public int top() {
//        return q.peek();
//    }
//
//    // Return whether the stack is empty.
//    public boolean empty() {
//        return q.isEmpty();
//    }
}
