package com.algo.string;

/*
 * https://leetcode.com/problems/check-if-the-sentence-is-pangram/
 */

public class PangramString_1832 {

	public static void main(String[] args) {

		String s = "thequickbrownfoxjumpsoverthelazydog";

		boolean isPanagram = checkIfPangram(s);
		System.out.println(isPanagram);

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

}
