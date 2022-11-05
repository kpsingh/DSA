package com.algo.recusrsion;

/*
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolnGrammar {

	public static void main(String[] args) {

		int result = kthGrammar(2, 2);
		System.out.println(result);

	}

	public static int kthGrammar(int n, int k) {

		StringBuilder sb = generate(n);

		String s = new String(sb);

		int result = Character.getNumericValue(s.charAt(k - 1));

		System.out.println(s);

		return result;

	}

	private static StringBuilder generate(int n) {

		if (n == 1) {
			StringBuilder ans = new StringBuilder("0");
			return ans;
		}

		StringBuilder s = generate(n - 1);

		StringBuilder ans = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '0') {
				ans.append("01");
			} else {
				ans.append("10");
			}
		}

		return ans;

	}

}
