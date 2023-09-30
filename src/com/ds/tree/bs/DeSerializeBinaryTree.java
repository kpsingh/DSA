package com.ds.tree.bs;

public class DeSerializeBinaryTree {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, -1, -1, -1, -1, -1, -1 };
		TreeNode root = solve(arr);
		System.out.println(root);
	}

	public static TreeNode solve(int[] arr) {
		int n = arr.length;
		return deserialize(arr, 0, n);
	}

	private static TreeNode deserialize(int[] arr, int id, int size) {
		if (id >= size || arr[id] == -1) {
			return null;
		}

		TreeNode root = new TreeNode(arr[id]);
		root.left = deserialize(arr, id * 2 + 1, size);
		root.right = deserialize(arr, id * 2 + 2, size);

		return root;
	}

	private boolean insertBST(TreeNode root, int x) {
		return false;
	}
}
