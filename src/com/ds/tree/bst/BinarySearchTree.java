package com.ds.tree.bst;

import com.ds.tree.bs.TreeNode;

public class BinarySearchTree {

	public boolean isValidBST(TreeNode root) {

		int left = Integer.MIN_VALUE;
		int right = Integer.MAX_VALUE;
		
		return valid(root, left, right);

	}

}
