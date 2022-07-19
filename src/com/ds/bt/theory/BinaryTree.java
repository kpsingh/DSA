package com.ds.bt.theory;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {

	/**
	 * Index will be used to traverse the array starting form 0th index.
	 */
	static int index = -1;

	public Node createBinaryTree(int[] arr) {

		index++;

		if (arr[index] == -1)
			return null;

		/**
		 * Create the Binary tree for PreOrder data given in the farm of array
		 * 
		 * PreOrder = Root-Left-Right
		 */

		Node root = new Node(arr[index]);
		root.left = createBinaryTree(arr);
		root.right = createBinaryTree(arr);

		return root;
	}

	public void preOrder(Node root) {
		/**
		 * PreOrder = Root- Left - Right
		 */

		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public void inOrder(Node root) {

		/**
		 * InOrder = Left - Root - Right
		 */

		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public void postOrder(Node root) {

		/**
		 * PostOrder = Left - Right - Root
		 */

		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");

	}

	public void levelOrder(Node root) {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		/**
		 * In order to differentiate across the level we have to use some mechanism, let
		 * say we put null into the queue and if null came that mean we are going to
		 * next level. We'll keep putting null to queue until the queue is not empty.
		 * 
		 * If we got null and queue is empty- break the loop and come out
		 * 
		 */
		
		q.add(null); // this to help in order to decide the next level

		while (!q.isEmpty()) {

			Node node = q.poll();

			if (node == null) {

				/**
				 * if value poll from Q is null then is two possibilities either Q is empty or
				 * null (to next line) if Q is empty then break other wise add the null to
				 * differentiate the next line.
				 */

				System.out.println();

				if (q.isEmpty())
					// that mean Q is empty
					break;
				else
					// Q is not empty, this null is just for differentiate next line
					q.add(null);

			} else {

				System.out.print(node.data + " ");

				if (node.left != null)
					q.add(node.left);

				if (node.right != null)
					q.add(node.right);
			}

		}

	}
}