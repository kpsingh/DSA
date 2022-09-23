package com.ds.stack.queue.questions;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 */

public class ValidParentheses_20 {
	public static void main(String[] args) {
		String s = "()[]{}";
		// String s = "]]";
		System.out.println(isValid(s));

	}

	public static boolean isValid(String s) {

		if (s.length() % 2 == 1)
			return false;

		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {

			if (c == '{') {
				stack.push('}');

			} else if (c == '(') {
				stack.push(')');

			} else if (c == '[') {
				stack.push(']');

			} else if (stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
	}
}
