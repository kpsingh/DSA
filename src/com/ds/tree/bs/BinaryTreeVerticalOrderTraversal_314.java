package com.ds.tree.bs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/*
 * https://leetcode.com/problems/binary-tree-vertical-order-traversal/description/
 * 
 * BFS - Level Order Traversal with slight changes
 * 
 * 	Input: root = [3,9,20,null,null,15,7]
	Output: [[9],[3,15],[20],[7]]

	Input: root = [3,9,8,4,0,1,7]
	Output: [[4],[9],[3,0,1],[8],[7]]

	Input: root = [3,9,8,4,0,1,7,null,null,null,2,5]
	Output: [[4],[9,5],[3,0,1],[8,2],[7]]
	
 * 
 */

public class BinaryTreeVerticalOrderTraversal_314 {

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		Queue<TreeNode> q = new LinkedList<>();

		Queue<Integer> cols = new LinkedList<>();

		q.add(root);
		cols.add(0);

		int min = 0;
		int max = 0;

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			int col = cols.poll();

			if (!map.containsKey(col)) {
				map.put(col, new ArrayList<Integer>());
			}
			map.get(col).add(node.val);

			if (node.left != null) {
				q.add(node.left);
				cols.add(col - 1);
				min = Math.min(min, col - 1);
			}

			if (node.right != null) {
				q.add(node.right);
				cols.add(col + 1);
				max = Math.max(max, col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			res.add(map.get(i));
		}

		return res;
	}

}
