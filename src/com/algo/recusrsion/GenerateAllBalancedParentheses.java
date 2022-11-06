package com.algo.recusrsion;

public class GenerateAllBalancedParentheses {

	public static void main(String[] args) {
		int n = 3;
		String op = "";
		generateAllBalancedParentheses(n, n, op);

	}

	private static void generateAllBalancedParentheses(int open, int close, String output) {
		if (open == 0 && close == 0) {
			System.out.println(output);
			return;
		}

		if (open == close) {
			String op1 = output + "{";
			generateAllBalancedParentheses(open - 1, close, op1);
		} else if (open == 0) {
			String op1 = output + "}";
			generateAllBalancedParentheses(open, close - 1, op1);
		} else {
			String op1 = output + "{";
			String op2 = output + "}";
			generateAllBalancedParentheses(open - 1, close, op1);
			generateAllBalancedParentheses(open, close - 1, op2);
		}

	}

}
