package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/description/
 */
public class GenerateAllBalancedParentheses_22 {

	static List<String> result = new ArrayList<>();

	public static void main(String[] args) {
		int n = 3;
		String op = "";
		generateParenthesis(n, n, op);

		for (String s : result) {
			System.out.println(s);
		}

	}

	private static void generateParenthesis(int open, int close, String output) {
		if (open == 0 && close == 0) {
			result.add(output);
			return;
		}

		if (open == close) {
			// only one choice :- open the bracket
			String op1 = output + "(";
			generateParenthesis(open - 1, close, op1);

		} else if (open == 0) {
			// only one choice : close the bracket
			String op1 = output + ")";
			generateParenthesis(open, close - 1, op1);

		} else {
			// we can have both choices - either start the bracket or close the bracket
			String op1 = output + "(";
			String op2 = output + ")";
			generateParenthesis(open - 1, close, op1);
			generateParenthesis(open, close - 1, op2);
		}
	}

}
