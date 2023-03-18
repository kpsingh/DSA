package com.algo.dp;

public class LCS {

	static String s1;
	static String s2;

	public static void main(String[] args) {

		String s1 = "bsbininm";
		String s2 = "jmjkbkjkv";

		System.out.println(longestCommonSubsequence(s1, s2));

	}

	/*
	 * Recursive LCS
	 */
	public static int longestCommonSubsequence(String text1, String text2) {
		s1 = text1;
		s2 = text2;

		// return lcs_rec(0, 0);
		return lcs_DP(text1, text2);
	}

	private static int lcs_rec(int i, int j) {
		if (i == s1.length() || j == s2.length()) {
			return 0;
		}

		if (s1.charAt(i) == s2.charAt(j)) {
			return 1 + lcs_rec(i + 1, j + 1);
		}

		int l = lcs_rec(i + 1, j);
		int r = lcs_rec(i, j + 1);

		return Math.max(l, r);
	}

	/*
	 * Dynamic Programming
	 */

	private static int lcs_DP(String s1, String s2) {
		
		int n = s1.length();
		int m = s2.length();

		if (n == 0 || m == 0) {
			return 0;
		}

		int[][] dp = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {

				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = 1 + Math.max(dp[i - 1][j], dp[i][j - 1]);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}

}
