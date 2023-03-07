package com.ds.tree.bs;

import java.util.Stack;

public class kthSmallestInBST {

	public int kthSmallest(TreeNode root, int k) {

		int count = 0;
		Stack<TreeNode> stack = new Stack<>();

		while (!stack.isEmpty() || root != null) {

			while (root != null) {

				stack.push(root);
				root = root.left;
			}

			root = stack.pop();

			count++;

			if (count == k) {
				return root.val;
			}

			root = root.right;

		}

		return -1;

	}

}
