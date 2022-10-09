package com.ds.linkedlist.questions;

public class RotateList_61 {

	public ListNode rotateRight(ListNode head, int k) {

		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(0, head);
		ListNode curr = head;

		while (k > 0) {
			curr = curr.next;
			k--;
		}

		ListNode prev = dummy;

		while (curr != null) {
			prev = prev.next;
			curr = curr.next;
		}

		ListNode head2 = prev.next;
		prev.next = null;

		curr = head2;

		while (curr != null) {
			prev = curr;
			curr = curr.next;

		}

		prev.next = dummy.next;

		return head2;

	}

}
