package com.ds.linkedlist.questions;

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

	ListNode head = null;
	ListNode tail = null;

	public ListNode reverseListRecursive(ListNode node) {

		if (node == null || node.next == null)
			return node;

		revese(node);

		tail.next = null;
		return head;
	}

	private void revese(ListNode node) {
		if (node.next == null) {
			head = node;
			tail = node;
		}

		ListNode prev = node;
		revese(node.next);
		tail.next = prev;
		tail = tail.next;

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
