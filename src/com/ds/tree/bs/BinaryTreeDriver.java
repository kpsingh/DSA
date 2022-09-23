package com.ds.tree.bs;

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

		Node root = bt.createBinaryTree(arr);

		System.out.println("Pre Order");

		bt.preOrder(root);

		System.out.println("\nIn Order");

		bt.inOrder(root);

		System.out.println("\nPost Order");

		bt.postOrder(root);

		System.out.println("\nLevel Order");

		bt.levelOrder(root);

		System.out.println("\nNode Count");

		System.out.println(bt.countNode(root));

		System.out.println("\nSum of the Nodes");

		System.out.println(bt.sumOfNode(root));

		System.out.println("\nHeigth of the tree");

		System.out.println(bt.heightOfTree(root));

	}

}
