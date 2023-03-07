package com.ds.tree.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTree {

	// https://leetcode.com/problems/validate-binary-search-tree/

	public boolean isValidBST(TreeNode root) {

		Long min = Long.MIN_VALUE;
		long max = Long.MAX_VALUE;

		return valid(root, min, max);

	}

	private boolean valid(TreeNode root, long min, long max) {

		if (root == null)
			return true;

		if (root.val <= min || root.val >= max)
			return false;

		return valid(root.left, min, root.val) && valid(root.right, root.val, max);

	}

	// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

	/**
	 * Basically we have to do In Order Traversal
	 */

	public int kthSmallest(TreeNode root, int k) {

		List<Integer> inOrder = new ArrayList<>();

		if (root == null)
			return -1;

		Stack<TreeNode> stack = new Stack<>();

		while (true) {

			if (root != null) {
				stack.push(root);
				root = root.left;

			} else {
				if (stack.isEmpty()) {
					break;
				}

				root = stack.pop();

				inOrder.add(root.val);

				if (inOrder.size() == k)
					return root.val;

				root = root.right;

			}

		}

		// since list has index is form 0 and in question it asked from 1
		return 0;

	}

	// this is good example of ITERATIVE : In Order Traversal
	public int kthSmallest_v2(TreeNode root, int k) {

		int n = 0;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;

		while (current != null || stack != null) {

			while (current != null) {
				stack.push(current);
				current = current.left;
			}

			TreeNode node = stack.pop();
			n++;
			if (n == k) {
				return node.val;
			}
			current = node.right;

		}

		return 0;

	}

}
