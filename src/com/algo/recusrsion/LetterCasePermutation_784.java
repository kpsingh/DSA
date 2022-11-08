package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

	private static List<String> result = new ArrayList<String>();

	public static void main(String[] args) {

		String str = "a1b2"; // Output: ["a1b2","a1B2","A1b2","A1B2"]

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

		String out1 = out;
		String out2 = out + input.substring(0, 1);

		letterCasePermutation(input.substring(1), out1);
		letterCasePermutation(input.substring(1), out2);

	}

}
