package com.ds.linkedlist.questions;

import java.util.ArrayList;

public class PalindromeLinkeList_234 {

	public boolean isPalindrome(ListNode head) {

		if (head == null || head.next == null)
			return true;

		ArrayList<Integer> list = new ArrayList<>();

		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		for (int i = 0, j = list.size() - 1; i < list.size() && j < i; i++, j--) {

			if (list.get(i) != list.get(j))
				return false;

		}
		return true;

	}

	public boolean isPalindrome_Recusrsive(ListNode head) {

		if (head == null || head.next == null)
			return true;

		ListNode mid = getMidle(head);
		ListNode head2 = reverse(mid);
		ListNode back = head2;

		while (head != null && head2 != null) {
			if (head.val != head2.val)
				break;
		}

		reverse(back);

		return head == null || head2 == null;

	}

	private ListNode reverse(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;
		ListNode next = head.next;

		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			next = next.next;
		}

		return prev;

	}

	private ListNode getMidle(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

}
