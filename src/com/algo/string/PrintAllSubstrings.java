package com.algo.string;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PrintAllSubstrings {

	public static void main(String[] args) {

		PrintAllSubstrings pSubstrings = new PrintAllSubstrings();
		int ans = pSubstrings.countSubstrings("abba");
		System.out.println("Total Palindrim : " + ans);

	}

	List<String> list = new ArrayList<String>();

	public int countSubstrings(String src) {

		for (int i = 0; i < src.length(); i++) {
			for (int j = i; j < src.length(); j++) {
				list.add(src.substring(i, j + 1));
			}
		}
		list = list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

		System.out.println(list);

		int count = 0;
		for (String s : list) {
			if (isPalindrom(s)) {
				System.out.println(s);
				count++;
			}
		}
		System.out.println();

		return count;
	}

	private boolean isPalindrom(String s) {

		if (s.length() < 2) {
			return true;
		}

		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			if (s.charAt(i) != s.charAt(j)) {
				return false;
			}
		}

		return true;
	}
}
