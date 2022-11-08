package com.algo.recusrsion;

import java.util.Stack;

public class ReverseStack_2_IBH {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();

		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");

		for (String s : stack) {
			System.out.print(s + " ");
		}
		System.out.println();

		reverse(stack);

		for (String s : stack) {
			System.out.print(s + " ");
		}

	}

	private static void reverse(Stack<String> stack) {

		// Base Condition : One element is always reverser or sorted

		if (stack.size() == 1) {
			return;
		}

		String s = stack.pop();
		reverse(stack);
		// Induction
		insert(stack, s);

	}

	private static void insert(Stack<String> stack, String target) {

		if (stack.size() == 0) {
			stack.push(target);
			return;
		}

		String temp = stack.pop();
		insert(stack, target);
		stack.push(temp);

	}

}
