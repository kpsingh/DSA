package com.ds.linkedlist;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 */

public class ReverseLinkedList_206 {

	public ListNode reverseListIterative(ListNode head) {

		if (null == head || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		return prev;

	}

	// Reverse LinkList Recursively

	ListNode head = null;
	ListNode tail = null;

	public ListNode reverseListRecursive(ListNode node) {

		if (node == null || node.next == null)
			return node;

		revese(node);

		return head;
	}

	private void revese(ListNode node) {

		if (node.next == null) {
			/**
			 * this mean we have reached to the last element of the list. In reverse this
			 * last node going to be head.
			 * 
			 * We'll keep moving the tail node making the earlier element as the next for
			 * tail.
			 */
			head = node;
			tail = node;
			return;
		}

		revese(node.next);
		tail.next = node; // this was earlier previous element and now the next element
		tail = node;
		tail.next = null;

	}

	public ListNode reverseListByStack(ListNode head) {

		if (null == head || head.next == null)
			return head;

		Stack<ListNode> stack = new Stack<>();

		ListNode temp = head;

		while (temp.next != null) {
			stack.push(temp);
			temp = temp.next;
		}

		head = temp;

		while (!stack.isEmpty()) {
			temp.next = stack.pop();
			temp = temp.next;

		}

		temp.next = null;

		return head;
	}

}
