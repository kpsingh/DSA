package com.ds.linkedlist.questions;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 */

public class ReverseLinkedList_206 {

	public ListNode reverseList(ListNode head) {
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

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
	}
}