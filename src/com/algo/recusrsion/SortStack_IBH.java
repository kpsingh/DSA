package com.algo.recusrsion;

import java.util.Stack;
/*
 * Induction - Base - Hypothesis
 */

public class SortStack_IBH {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(5);
		stack.push(4);
		stack.push(9);

		System.out.println("Before Sorting");
		for (int a : stack) {
			System.out.print(a + " ");
		}

		System.out.println();

		sort(stack);

		System.out.println("After Sorting");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
	}

	private static void sort(Stack<Integer> stack) {
		if (stack.size() == 1) {
			return;
		}

		int temp = stack.pop();
		sort(stack);
		insert(stack, temp);

	}

	private static void insert(Stack<Integer> stack, int target) {
		if (stack.isEmpty() || stack.peek() >= target) {
			stack.push(target);
			return;
		}

		int temp2 = stack.pop();
		insert(stack, target);
		stack.push(temp2);
	}

}
