package com.ds.linkedlist;

/*
https://leetcode.com/problems/middle-of-the-linked-list/

https://leetcode.com/problems/middle-of-the-linked-list/submissions/


 */
public class MiddleoftheLinkedList_876 {

	public ListNode middleNode(ListNode head) {

		/*
		 * with the help of slow and fast pointer we can solve this problem. once the
		 * fast pointer reched to null or its next is null then at that time where the
		 * slow pointer reached that will be the middle of the linked list.
		 */

		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;

	}

}
