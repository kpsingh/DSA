package com.algo.string;

/*
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

public class PangramString_1832 {

	public static void main(String[] args) {

		String s = "thequickbrownfoxjumpsoverthelazydog";

		boolean isPanagram = checkIfPangram(s);
		System.out.println(isPanagram);
		System.out.println(checkIfPangram_V2(s));

		System.out.println((int) 'a'); // 97

	}

	public static boolean checkIfPangram(String sentence) {

		if (sentence.length() < 26) {
			return false;
		}

		for (int i = 1; i <= 26; i++) {
			if (sentence.indexOf((char) i + 96) < 0) {
				return false;
			}
		}

		return true;

	}

	public static boolean checkIfPangram_V2(String sentence) {

		if (sentence.length() < 26) {
			return false;
		}

		int[] arr = new int[26];

		for (int i = 0; i < sentence.length(); i++) {
			arr[sentence.charAt(i) - 'a'] = 1;
		}

		for (int a : arr) {
			if (a == 0)
				return false;
		}
		return true;

	}

}
