package com.ds.linkedlist;

public class RemoveNthFromEnd_19 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode curr = head;

		while (n > 0) {
			curr = curr.next;
			n--;
		}

		while (curr != null) {
			curr = curr.next;
			prev = prev.next;
		}

		prev.next = prev.next.next;

		return dummy.next;

	}

}
