package com.ds.linkedlist;

public class OddEvenLinkedList_328 {

	public ListNode oddEvenList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode head1 = head;
		ListNode head2 = head.next;

		ListNode odd = head1;
		ListNode even = head2;

		while (even != null && even.next != null) {
			odd.next = odd.next.next;
			odd = odd.next;

			even.next = even.next.next;
			even = even.next;
		}

		odd.next = head2;
		return head1;

	}

}
