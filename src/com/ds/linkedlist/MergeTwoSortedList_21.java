package com.ds.linkedlist;

/**
 * 
 * https://leetcode.com/problems/merge-two-sorted-lists/description/
 *
 */
public class MergeTwoSortedList_21 {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		list1.next = node2;
		node2.next = node3;

		ListNode list2 = new ListNode(1);
		ListNode node21 = new ListNode(3);
		ListNode node22 = new ListNode(4);
		list2.next = node21;
		node21.next = node22;

		ListNode ans = mergeTwoLists(list1, list2);

		while (ans != null) {
			System.out.print(ans.val + " -> ");
			ans = ans.next;
		}
		System.out.println("End");

	}

	public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

		// More advance version

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
