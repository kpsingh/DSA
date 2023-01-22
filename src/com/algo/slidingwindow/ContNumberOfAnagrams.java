package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class ContNumberOfAnagrams {

	public static void main(String[] args) {

		String s = "cbaebacb";
		String p = "abc";

		int countOfAnagrams = getCount(s, p);
		System.out.println(countOfAnagrams);
	}

	private static int getCount(String str, String ptr) {

		int result = 0;

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < ptr.length(); i++) {
			map.put(ptr.charAt(i), map.getOrDefault(ptr.charAt(i), 0) + 1);
		}

		int count = map.size();
		// System.out.println(count);

		int i = 0;
		int j = 0;

		while (j < str.length()) {

			Character key = str.charAt(j);

			if (j - i + 1 < ptr.length()) {
				// no window size

				if (map.containsKey(key)) {
					// that mean the key already exit in the map and we can reduce it ., if it is
					// zero that mean not present then do nothing as it not belong to anagram String

					if (map.get(key) == 0) {
						map.put(key, map.get(key) - 1);
						count++;
					}

					map.put(key, map.get(key) - 1);

					if (map.get(key) == 0) {
						count--;
					}
				}

				j++;

			} else {
				// now we have the window size

				if (map.containsKey(key)) {
					// that mean the key already exit in the map and we can reduce it ., if it is
					// zero that mean not present then do nothing as it not belong to anagram String

					if (map.get(key) == 0) {
						map.put(key, map.get(key) - 1);
						count++;
					}

					map.put(key, map.get(key) - 1);

					if (map.get(key) == 0) {
						count--;
					}

					if (count == 0) {
						result++;
					}
				}

				if (map.containsKey(str.charAt(i))) {

					map.put(str.charAt(i), map.get(str.charAt(i)) + 1);

					if (map.get(str.charAt(i)) == 0) {
						count--;
					}

				}

				i++;
				j++;

			}
		}

		return result;
	}
}