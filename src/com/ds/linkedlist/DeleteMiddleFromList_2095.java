package com.ds.linkedlist;

public class DeleteMiddleFromList_2095 {

	public ListNode deleteMiddle(ListNode head) {
		if (head == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = slow.next; // OR pre.next.next;

		return dummy.next;
	}

}
