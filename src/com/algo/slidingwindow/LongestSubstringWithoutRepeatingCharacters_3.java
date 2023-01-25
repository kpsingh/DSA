package com.algo.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public static void main(String[] args) {
		// String s = "abcabcbb";
		// String s = "dvdf";
		// String s = " ";
		String s = "tmmzuxt";

		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) {

		if (s.length() == 0 || s.length() == 1) {
			return s.length();
		}

		int ans = 0;
		int i = 0;
		int j = 0;

		Set<Character> set = new HashSet<>();
		boolean added = false;

		while (j < s.length()) {

			Character c = s.charAt(j);
			added = set.add(c);

			if (!added) {

				while (set.contains(c)) {
					set.remove(s.charAt(i));
					i++;
				}
				set.add(c);

			}

			ans = Math.max(ans, j - i + 1);
			j++;

		}

		return ans;

	}

}
