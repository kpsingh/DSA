package com.ds.linkedlist;

public class ReorderList_143 {

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		ListNode midle = middle(head);
		ListNode head2 = reverse(midle);

		while (head != null && head2 != null) {

			ListNode temp = head.next;
			head.next = head2;
			head = temp;

			temp = head2.next;
			head2.next = head;
			head2 = temp;
		}

		if (head != null)
			head.next = null;
	}

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
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

	private ListNode middle(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
