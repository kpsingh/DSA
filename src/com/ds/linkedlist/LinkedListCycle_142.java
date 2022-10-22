package com.ds.linkedlist;

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/description/ *
 */

public class LinkedListCycle_142 {

	public ListNode detectCycle(ListNode head) {

		if (head == null || head.next == null)
			return null;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				/**
				 * it mean cycle exit, now we need to figure out where cycle started.
				 * 
				 * Slow started from head and fast from where both have meet, they will again
				 * meet at the start of the cycle
				 */

				slow = head;

				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}

				return slow;
			}

		}
		return null;

	}

	public int detectCycleLength(ListNode head) {

		if (head == null || head.next == null)
			return 0;

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				// Cycle exist

				int length = 0;

				do {
					slow = slow.next;
					length++;
				} while (slow != fast);

				return length;
			}

		}
		return 0; // if no cycle

	}

}
