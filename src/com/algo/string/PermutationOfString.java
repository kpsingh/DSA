package com.algo.string;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class PermutationOfString {

	private static Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		String str = "abc";

		System.out.println("Permutations");
		permute(str, "");
		System.out.println("Power Set");

		set.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

	}

	private static void permute(String src, String ans) {
		set.add(src); // collect all sets of string

		if (src.isBlank()) {
			System.out.println(ans); // permutations
			return;
		}

		for (int i = 0; i < src.length(); i++) {
			String newSrc = src.substring(0, i) + src.substring(i + 1);
			permute(newSrc, ans + src.charAt(i));
		}
	}

}
