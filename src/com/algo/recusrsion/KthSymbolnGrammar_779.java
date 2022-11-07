package com.algo.recusrsion;

/*
 * https://leetcode.com/problems/k-th-symbol-in-grammar/
 */
public class KthSymbolnGrammar_779 {

	public static void main(String[] args) {

		int result = kthGrammar(2, 2);
		System.out.println(result);

	}

	public static int kthGrammar(int n, int k) {

		if (n == 0 && k == 0) {
			return 0;
		}

		int mid = (int) (Math.pow(2, n - 1)) / 2;

		if (k <= mid) {
			return kthGrammar(n - 1, k);
		} else {

			int result = kthGrammar(n - 1, k - mid);

			return result == 1 ? 0 : 1;
		}

	}

}
