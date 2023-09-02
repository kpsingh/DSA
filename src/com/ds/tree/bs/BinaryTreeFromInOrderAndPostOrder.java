package com.ds.tree.bs;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInOrderAndPostOrder {

	Map<Integer, Integer> map = new HashMap<>();

	public static void main(String[] args) {

		BinaryTreeFromInOrderAndPostOrder bs = new BinaryTreeFromInOrderAndPostOrder();
		int[] A = {5};
		int[] B = {5};

		bs.buildTree(A, B);

	}

	public TreeNode buildTree(int[] A, int[] B) {
		int inStart = 0;
		int inEnd = A.length - 1;

		int posStart = 0;
		int posEnd = B.length - 1;

		for (int i = 0; i < A.length; i++) {
			map.put(A[i], i);
		}

		return buildTree(A, B, inStart, inEnd, posStart, posEnd);
	}

	private TreeNode buildTree(int[] A, int[] B, int inStart, int inEnd, int posStart, int posEnd) {
		if (inStart > inEnd) {
			return null;
		}

		int rootIndex = map.get(B[posEnd]); // since postfix... last element is the rootIndex
		int elementCount = rootIndex - inStart; // number of element before root index to decide left and right half

		TreeNode root = new TreeNode(A[rootIndex]);
		root.left = buildTree(A, B, inStart, rootIndex - 1, posStart, posStart + elementCount - 1);
		root.right = buildTree(A, B, rootIndex + 1, inEnd, posStart + elementCount, posEnd - 1);

		return root;

	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
}
