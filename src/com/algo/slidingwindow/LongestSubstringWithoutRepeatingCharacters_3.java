package com.algo.slidingwindow;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public static void main(String[] args) {
		// String s = "abcabcbb";
		// String s = "dvdf";
		String s = " ";
		//String s = "tmmzuxt";

		int result = lengthOfLongestSubstring(s);
		System.out.println(result);
	}

	public static int lengthOfLongestSubstring(String s) {

		int[] chars = new int[128];

		int left = 0;
		int right = 0;
		int res = 0;

		while (right < s.length()) {

			char r = s.charAt(right);
			chars[r]++;

			while (chars[r] > 1) {
				char l = s.charAt(left);
				chars[l]--;
				left++;
			}

			res = Math.max(res, right - left + 1);

			right++;
		}
		return res;
	}

}

/*
 * public static int lengthOfLongestSubstring(String s) {
 * 
 * int result = 0; int i = 0; int j = 0; boolean added = false;
 * HashSet<Character> set = new HashSet<>();
 * 
 * while (j < s.length()) {
 * 
 * Character key = s.charAt(j);
 * 
 * if (key == ' ') { key = null; } added = set.add(key);
 * 
 * if (!added) { result = Math.max(j - i, result);
 * 
 * while (key != null && key != s.charAt(i)) { i++; } i++;
 * 
 * } else { result = Math.max(j - i + 1, result); } j++; } return result; }
 */
