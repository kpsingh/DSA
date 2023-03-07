package com.ds.tree.bs;

public class IsValidBST_98 {

	public boolean isValidBST(TreeNode root) {

		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		return isValidBST(root, min, max);

	}

	private boolean isValidBST(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}

		if (root.val < min || root.val > max) {
			return false;
		}

		return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);

	}

}
