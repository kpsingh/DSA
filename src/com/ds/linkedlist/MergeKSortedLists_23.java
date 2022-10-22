package com.ds.linkedlist;

public class MergeKSortedLists_23 {

	public ListNode mergeKLists(ListNode[] arr) {
		
		if (arr == null || arr.length == 0)
			return null;

		return mergeKLists(arr, 0, arr.length - 1);

	}

	private ListNode mergeKLists(ListNode[] arr, int start, int end) {

		if (start == end) {
			return arr[start];
		}
		// Mid of list of lists
		int mid = start + (end - start) / 2;
		// Recursive call for left sublist
		ListNode left = mergeKLists(arr, start, mid);
		// Recursive call for right sublist
		ListNode right = mergeKLists(arr, mid + 1, end);
		// Merge the left and right sublist
		return mergeTwoLists(left, right);
	}

	private ListNode mergeTwoLists(ListNode list1, ListNode list2) {

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
