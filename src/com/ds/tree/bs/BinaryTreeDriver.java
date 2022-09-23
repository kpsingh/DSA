package com.ds.tree.bs;

import java.util.List;

public class BinaryTreeDriver {

	public static void main(String[] args) {

		/**
		 * pass the array for which we want to create the tree. Suppose the data in the
		 * array are given in pre-order manner
		 */

		int[] arr = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		BinaryTree bt = new BinaryTree();

		/**
		 * Create the Binary Tree and return the root node of that tree.
		 */

		TreeNode root = bt.createBinaryTree(arr);

		List<List<Integer>> leverOrderList = bt.leverOrderList(root);
		for (List<Integer> level : leverOrderList) {
			System.out.println(level);
		}
		
		
		bt.preOrderIterative(root);
		bt.preOrder(root);
		

	}

}
