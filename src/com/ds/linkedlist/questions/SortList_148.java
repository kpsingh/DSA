package com.ds.linkedlist.questions;

/**
 * https://leetcode.com/problems/sort-list/
 * 
 */
public class SortList_148 {

	public static void main(String[] args) {
		SortList_148 list = new SortList_148();

		ListNode head = new ListNode(4);
		ListNode n2 = new ListNode(2);
		ListNode n1 = new ListNode(1);
		ListNode n3 = new ListNode(3);

		head.next = n2;
		n2.next = n1;
		n1.next = n3;

		head = list.sortList(head);

		while (head != null) {
			System.out.print(head.val + " -> ");
			head = head.next;
		}
		System.out.println("End");

	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves

		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null; // making next as null we are cutting the list into two parts

		// step 2. sort each half

		ListNode left = sortList(head);
		ListNode right = sortList(slow);

		// step 3. return the sorted list
		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		if (list1 == null || list2 == null)
			return list1 == null ? list2 : list1;

		ListNode ans = new ListNode(0);
		ListNode head = ans;

		while (list1 != null && list2 != null) {

			if (list1.val < list2.val) {

				head.next = list1;
				list1 = list1.next;

			} else {
				head.next = list2;
				list2 = list2.next;

			}
			head = head.next;

		}

		head.next = list1 != null ? list1 : list2;

		return ans.next;

	}
}