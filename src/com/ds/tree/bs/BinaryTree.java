package com.ds.tree.bs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;

class BinaryTree {

	/**
	 * Index will be used to traverse the array starting form 0th index.
	 */
	static int index = -1;

	public TreeNode createBinaryTree(int[] arr) {

		index++;

		if (index >= arr.length || arr[index] == -1)
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

	// ******** VERTICAL ORDER - Start ********

	/**
	 * Unsing the TreeMap since the order matter for row entries and colums entris
	 * as well
	 * 
	 * this map will be a column map, each column as key and the value -- since a
	 * column can have multiple row and each row can have list o of values value for
	 * each colmn map is also a map and we say it row map. row map will have row num
	 * as key and then value in list. Since we want the values to be orderede for
	 * each row and col hence using the TreeMap key - colmn number val - row map for
	 * each coln
	 */

	private Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();

	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if (root == null) {
			return ans;
		}
		// The root of the tree is at (0, 0)
		inOrder(root, 0, 0);

		map.entrySet().stream().forEach(col -> {
			List<Integer> verticalOrder = new ArrayList<>();
			col.getValue().entrySet().stream().forEach(row -> {
				Collections.sort(row.getValue());
				verticalOrder.addAll(row.getValue());
			});
			ans.add(verticalOrder);
		});

		return ans;

	}

	private void inOrder(TreeNode root, int row, int col) {
		if (root == null) {
			return;
		}
		// Do some logic and then call for the root.left and right.right subtree

		Map<Integer, List<Integer>> levelMap = null; // each colum will have this map, and internally colum map wil have
														// the entry for each row.
		List<Integer> list = null; // this list will have entry for each row for a given column

		// check if that column is present or not
		if (!map.containsKey(col)) {
			// if colum is not present then create one and create one row map and add
			list = new ArrayList<>();
			list.add(root.val);
			levelMap = new TreeMap<>();
			levelMap.put(row, list);
			map.put(col, levelMap);

		} else {
			// if column entry exist then cehck if this row is exit for coumn or not
			levelMap = map.get(col);
			// check if for given colum, this row is present or not

			if (!levelMap.containsKey(row)) {
				// if row is not present then add new row
				list = new ArrayList<>();
				list.add(root.val);
				levelMap.put(row, list);
			} else {
				// if the row is already present then add on the list of row
				levelMap.get(row).add(root.val);
			}

		}

		inOrder(root.left, row + 1, col - 1);
		inOrder(root.right, row + 1, col + 1);

	}

	// ******** VERTICAL ORDER - END ********

	// DFS Traversal
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

	public List<Integer> preorderTraversal_Advance(TreeNode root) {

		List<Integer> ans = new LinkedList<>();
		Deque<TreeNode> deq = new LinkedList<>();
		while (root != null || !deq.isEmpty()) {
			if (root != null) {
				ans.add(root.val);
				deq.offerLast(root);
				root = root.left;
			} else {
				root = deq.pollLast().right;
			}
		}
		return ans;
	}

	// DFS Traversal
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

	public List<Integer> inOrderIterative_Advance(TreeNode root) {

		List<Integer> inorder = new ArrayList<>();

		// now it is recommendedn to use DeQueue instead of Stack
		Deque<TreeNode> deq = new ArrayDeque<>();

		while (root != null || deq != null) {
			if (root != null) {
				deq.offerLast(root);
				root = root.left;
			} else {
				inorder.add(deq.peekLast().val);
				root = deq.pollLast().right;
			}

		}

		return inorder;

	}

	// DFS Traversal
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

	public List<List<Integer>> leverOrder_Zigzag(TreeNode root) {

		List<List<Integer>> allLevels = new ArrayList<>();

		if (root == null)
			return allLevels;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		boolean flip = false;

		while (!queue.isEmpty()) {

			int length = queue.size();
			ArrayList<Integer> level = new ArrayList<>();

			for (int i = 0; i < length; i++) {

				TreeNode node = queue.remove();
				level.add(node.val);

				if (node.left != null)
					queue.add(node.left);

				if (node.right != null)
					queue.add(node.right);

			}

			if (flip)
				Collections.reverse(level);

			allLevels.add(level);
			flip = !flip;

		}

		return allLevels;

	}

	// another Way for BFS Traversal

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

	// Brute force approach for height of the tree and if it is balanced
	public int heightOfTree(TreeNode root) {

		if (root == null)
			return 0;

		int lh = heightOfTree(root.left);
		int rh = heightOfTree(root.right);

		return 1 + Math.max(lh, rh);

	}

	public boolean isBalanced_BruteForce(TreeNode root) {

		if (root == null)
			return true;

		int l = this.heightOfTree(root.left);
		int r = this.heightOfTree(root.right);
		int diff = Math.abs(l - r);

		return diff > 1 ? false : (isBalanced(root.left) && isBalanced(root.right));

	}

	/**
	 * 
	 * Advance version of Height and balance check
	 * 
	 * return the actual height only if it is balanced BT otherwise return -1;
	 * 
	 */

	private int dfsHeight(TreeNode root) {

		if (root == null)
			return 0;

		int lh = dfsHeight(root.left);
		if (lh == -1)
			return -1;

		int rh = dfsHeight(root.right);
		if (rh == -1)
			return -1;

		if (Math.abs(lh - rh) > 1)
			return -1;

		return Math.max(lh, rh) + 1;

	}

	public boolean isBalanced(TreeNode root) {
		return dfsHeight(root) != -1;

	}

	/**
	 * Diameter of a tree
	 */

	private int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		getDiameter(root);
		return diameter;

	}

	private int getDiameter(TreeNode root) {

		if (root == null)
			return 0;

		int lh = getDiameter(root.left);
		int rh = getDiameter(root.right);

		diameter = Math.max(diameter, lh + rh);

		return 1 + Math.max(lh, rh);

	}

	/**
	 * If two trees are same or not
	 */

	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null & q == null)
			return true;

		if (p == null || q == null)
			return false;

		return (p.val == q.val) && (isSameTree(p.left, q.left)) && (isSameTree(p.right, q.right));

	}

	/**
	 * LCA : Lowest Common Ancestor in Binary Tree
	 * 
	 * https://www.youtube.com/watch?v=KobQcxdaZKY
	 * 
	 * https://afteracademy.com/blog/lowest-common-ancestor-of-a-binary-tree#:~:text=An%20intuition%20for%20an%20iterative,as%20we%20traverse%20the%20tree.
	 */

	public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null)
			return null;

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = LCA(root.left, p, q);

		TreeNode right = LCA(root.right, p, q);

		if (left != null && right != null) {
			return root;
		}

		return left != null ? left : right;

	}

	public TreeNode LCA_Iterative(TreeNode root, TreeNode node1, TreeNode node2) {

		// This is iterative approach

		if (root == null || root == node1 || root == node2)
			return root;

		HashMap<TreeNode, TreeNode> map = new HashMap<>();
		Stack<TreeNode> stack = new Stack<>();

		map.put(root, null);
		stack.push(root);

		while (!map.containsKey(node1) || !map.containsKey(node2)) {

			TreeNode node = stack.pop();

			if (node.right != null) {
				map.put(node.right, node);
				stack.push(node.right);
			}

			if (node.left != null) {
				map.put(node.left, node);
				stack.push(node.left);
			}

		}

		Set<TreeNode> path = new HashSet<>();

		while (node1 != null) {
			path.add(node1);
			node1 = map.get(node1);
		}

		while (!path.contains(node2)) {
			node2 = map.get(node2);
		}

		return node2;

	}

	// https://leetcode.com/problems/invert-binary-tree/description/

	public TreeNode invertTree(TreeNode root) {

		if (root == null)
			return root;

		// swap the node
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		// do the same for left subtree and right subtree

		invertTree(root.left);
		invertTree(root.right);

		// once done for left and right then return

		return root;

	}

}
