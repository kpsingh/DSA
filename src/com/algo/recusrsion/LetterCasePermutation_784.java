package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

	private static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {

		String str = "C"; // Output: ["a1b2","a1B2","A1b2","A1B2"]

		letterCasePermutation(str);

		for (String s : result) {
			System.out.println(s);
		}

	}

	private static List<String> letterCasePermutation(String input) {

		String out = "";

		letterCasePermutation(input, out);

		return result;

	}

	private static void letterCasePermutation(String input, String out) {
		if (input.isBlank()) {
			result.add(out);
			return;
		}

		String s = input.substring(0, 1);

		String out1 = out;
		String out2 = out;

		if (s.equals(s.toUpperCase()) && s.equals(s.toLowerCase())) {
			out1 = out1 + s;
			letterCasePermutation(input.substring(1), out1);

		} else {
			out1 = out1 + s.toUpperCase();
			out2 = out2 + s.toLowerCase();
			letterCasePermutation(input.substring(1), out1);
			letterCasePermutation(input.substring(1), out2);
		}

	}

}
