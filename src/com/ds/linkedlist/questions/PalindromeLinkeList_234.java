package com.ds.linkedlist.questions;

import java.util.ArrayList;

public class PalindromeLinkeList_234 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;

		// This is in place algorithm

		ListNode midle = getMiddle(head);

		ListNode head2 = reverse(midle);

		ListNode backUp = head2;// keeping backup so post Palindrome check we need to revert the original list

		while (head != null && head2 != null) {

			if (head.val != head2.val) {
				/**
				 * if we are not bothering reverting back the original list then simply we can
				 * return false from here instead of break;
				 */

				break;
			}

			head = head.next;
			head2 = head2.next;
		}

		reverse(backUp); // make the reverse list as original

		/**
		 * if any one list is empty that mean no mismatch found and we never entered
		 * into break ->> its Palindrome
		 */

		return head == null || head2 == null;

		/**
		 * advance way for below
		 * 
		 * if (head == null || head2 == null) return true;
		 * 
		 * else return false;
		 * 
		 */

	}

	private ListNode getMiddle(ListNode head) {
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

	private ListNode reverse(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode prev = null;
		ListNode curr = head;

		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public boolean isPalindrome_ExtraMemory(ListNode head) {

		// this approach need an O(N) space complexity

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
}
