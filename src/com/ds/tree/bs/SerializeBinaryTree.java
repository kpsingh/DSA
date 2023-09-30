package com.ds.tree.bs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class SerializeBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(solve(root));

	}

	public static ArrayList<Integer> solve(TreeNode root) {
		
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
		
		while(q.size() != 0) {
			root = q.poll();
			if(root == null) {
				ans.add(-1);
				continue;
			}
			ans.add(root.val);
			q.offer(root.left);
			q.offer(root.right);
		}
		
		return ans;
	}

}
