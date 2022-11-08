package com.algo.recusrsion;

import java.util.Stack;

/*
 * Induction - Base - Hypothesis
 */

public class ReverseStack_IBH {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		System.out.println("Befor Reveresal");
		for (int a : stack) {
			System.out.print(a + " ");
		}

		System.out.println();

		reverse(stack);

		System.out.println("After Reveresal");
		for (int a : stack) {
			System.out.print(a + " ");
		}
		System.out.println();

	}

	private static void reverse(Stack<Integer> stack) {

		if (stack.size() == 1) {
			return;
		}

		int temp = stack.pop();
		reverse(stack);
		insert(stack, temp);

	}

	private static void insert(Stack<Integer> stack, int target) {

		if (stack.size() == 0) {
			stack.push(target);
			return;
		}

		int temp2 = stack.pop();
		insert(stack, target);
		stack.push(temp2);

	}

}
