package com.ds.tree.bs;

public class BinaryTreeDriver {

	public static void main(String[] args) {

		/**
		 * pass the array for which we want to create the tree. Suppose the data in the
		 * array are given in pre-order manner
		 */

		// int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

		BinaryTree bt = new BinaryTree();

		/**
		 * Create the Binary Tree and return the root node of that tree.
		 */

		// TreeNode root = bt.createBinaryTree(arr);

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(6);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(7);

		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(4);

		/*
		 * List<List<Integer>> leverOrder_V1 = bt.leverOrder_V1(root);
		 * 
		 * for (List<Integer> level : leverOrder_V1) { System.out.println(level); }
		 */

		root = bt.LCA(root, root.right, root.right.right);

		System.out.println(root.val);

	}

}
