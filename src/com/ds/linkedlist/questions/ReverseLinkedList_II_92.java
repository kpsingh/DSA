package com.ds.linkedlist.questions;

/**
 * 
 * https://www.youtube.com/watch?v=RF_M9tX4Eag
 * 
 * 
 * https://anj910.medium.com/leetcode-92-reverse-linked-list-ii-23a1eaab186
 * 
 * The idea is to divide the linked list into 3 parts:
 * 
 * a. dummy -> head -> … -> the node before m
 * 
 * b. node m -> …. -> node n (will be reversed, so later will be node n ->…->
 * node m)
 * 
 * c. the node right after n -> …. -> null
 * 
 * Hence, the step of the code will be:
 * 
 * 1. keep traversing the linked list till we reach node m
 * 
 * 2. reverse part b of the linked list
 * 
 * 3. bond the tail of part a with the head of part b (i.e., node n)
 * 
 * 4. bond the tail of part b (i.e., node m) with the head of part c.
 * 
 * 
 */

public class ReverseLinkedList_II_92 {

	public ListNode reverseBetween(ListNode head, int left, int right) {

		if (head == null || head.next == null)
			return head;

		/**
		 * Idea is to divide the list into 3 parts, part 'a' and part 'c' no change only
		 * part 'b' need to be reversed and then connect to part 'a' and part 'c'.
		 */

		// Step 1.
		ListNode dummy = new ListNode(0, head);
		ListNode prev = dummy;

		for (int i = 0; i < left - 1; i++) {
			prev = head;
			head = head.next;
		}
		// Step 2.
		ListNode a_tail = prev; // tail of part a
		ListNode b_tail = head; // "tail of part b"

		prev = null; // later will be the head of b
		ListNode curr = head; // later will be head of part c

		for (int i = 0; i < (right - left + 1); i++) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		// Step 3. connect tail of a and head of b
		a_tail.next = prev;

		// Step 4. connect tail of b and head of c
		b_tail.next = curr;

		return dummy.next;

	}

}
