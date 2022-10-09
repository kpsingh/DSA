package com.ds.linkedlist.questions;

public class RotateList_61 {

	public ListNode rotateRight(ListNode head, int k) {

		if (k <= 0 || head == null || head.next == null)
			return head;

		int length = 1;
		ListNode curr = head;
		while (curr.next != null) {
			curr = curr.next;
			length++;
		}

		curr.next = head;

		k = k % length;

		int skip = length - k - 1;

		curr = head;

		for (int i = 0; i < skip; i++) {
			curr = curr.next;
		}

		head = curr.next;

		curr.next = null;

		return head;

	}

}
