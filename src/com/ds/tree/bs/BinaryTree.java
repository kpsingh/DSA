package com.ds.tree.bs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class BinaryTree {

	/**
	 * Index will be used to traverse the array starting form 0th index.
	 */
	static int index = -1;

	public TreeNode createBinaryTree(int[] arr) {

		index++;

		if (arr[index] == -1)
			return null;

		/**
		 * Create the Binary tree for PreOrder data given in the farm of array
		 * 
		 * PreOrder = Root-Left-Right
		 */

		TreeNode root = new TreeNode(arr[index]);
		root.left = createBinaryTree(arr);
		root.right = createBinaryTree(arr);

		return root;
	}

	public void preOrder(TreeNode root) {
		/**
		 * PreOrder = Root- Left - Right
		 */

		if (root == null)
			return;

		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public List<Integer> preOrderIterative(TreeNode root) {

		List<Integer> preOrder = new ArrayList<>();

		if (root == null)
			return preOrder;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (stack.size() > 0) {

			TreeNode node = stack.pop();
			preOrder.add(node.val);

			if (node.right != null)
				stack.push(node.right);

			if (node.left != null)
				stack.push(node.left);
		}
		return preOrder;

	}

	public void inOrder(TreeNode root) {

		/**
		 * InOrder = Left - Root - Right
		 */

		if (root == null)
			return;

		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);

	}

	public List<Integer> inOrderIterative(TreeNode root) {

		List<Integer> inorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		TreeNode node = root;

		while (true) {

			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				if (stack.isEmpty())
					break;

				node = stack.pop();
				inorder.add(node.val);
				node = node.right;

			}

		}

		return inorder;

	}

	public void postOrder(TreeNode root) {

		/**
		 * PostOrder = Left - Right - Root
		 */

		if (root == null)
			return;

		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");

	}

	public List<Integer> postOrderIterative_V1(TreeNode root) {

		List<Integer> postorder = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> finalStack = new Stack<>();

		if (root == null)
			return postorder;

		stack.push(root);

		while (stack.size() > 0) {

			TreeNode node = stack.pop();

			finalStack.push(node);

			if (node.left != null)
				stack.push(node.left);

			if (node.right != null)
				stack.push(node.right);
		}

		while (finalStack.size() > 0) {

			postorder.add(finalStack.pop().val);
		}

		return postorder;

	}

	public List<Integer> postOrderIterative_V2(TreeNode root) {

		// -- 2nd approach, purely iteratively

		/**
		 * LOGIC: push each node twice onto the stack. Each time we pop a node, - if we
		 * see that there is a same node on the stack, we know that we have not done
		 * traversing yet, and need to keep pushing the current node's children onto the
		 * stack. - if the stack is empty, or the top element is not the same as the
		 * current element, we know that we're done searching with this node, thus we
		 * can add this node to the result.
		 */

		List<Integer> ans = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root != null) {
			stack.push(root);
			stack.push(root);
		}
		while (!stack.isEmpty()) {

			TreeNode curr = stack.pop();

			if (!stack.isEmpty() && curr == stack.peek()) {
				if (curr.right != null) {
					stack.push(curr.right);
					stack.push(curr.right);
				}
				if (curr.left != null) {
					stack.push(curr.left);
					stack.push(curr.left);
				}
			} else
				ans.add(curr.val);
		}
		return ans;
	}

	// BFS Traversal

	public List<List<Integer>> leverOrder_V1(TreeNode root) {

		ArrayList<List<Integer>> allLevel = new ArrayList<List<Integer>>();

		if (root == null)
			return allLevel;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (queue.size() > 0) {

			int count = queue.size();

			ArrayList<Integer> level = new ArrayList<Integer>();

			for (int i = 0; i < count; i++) {

				root = queue.remove();

				level.add(root.val);

				if (root.left != null)
					queue.add(root.left);
				if (root.right != null)
					queue.add(root.right);
			}
			allLevel.add(level);
		}
		return allLevel;
	}

	// another Way for leverOrder_V1

	public void levelOrder_V2(TreeNode root) {

		Queue<TreeNode> q = new LinkedList<>();
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

			TreeNode node = q.poll();

			if (node == null) {

				/**
				 * if value poll from Q is null then is two possibilities either Q is empty or
				 * null (to next line) if Q is empty then break other wise add the null to
				 * differentiate the next level.
				 */

				System.out.println();

				if (q.isEmpty())
					// that mean Q is empty
					break;
				else
					// Q is not empty, this null is just for differentiate next level
					q.add(null);

			} else {

				System.out.print(node.val + " ");

				if (node.left != null)
					q.add(node.left);

				if (node.right != null)
					q.add(node.right);
			}

		}

	}

	public int countNode(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + countNode(root.left) + countNode(root.right);
	}

	public int sumOfNode(TreeNode root) {

		if (root == null)
			return 0;

		return root.val + sumOfNode(root.left) + sumOfNode(root.right);

	}

	public int heightOfTree(TreeNode root) {

		if (root == null)
			return 0;

		return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));

	}

}
