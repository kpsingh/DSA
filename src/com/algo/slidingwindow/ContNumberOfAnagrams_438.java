package com.algo.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContNumberOfAnagrams_438 {

	public static void main(String[] args) {

		// String s = "cbaebacb";
		// String p = "abc";

		String s = "cbaebabacd";
		String p = "abc";

		List<Integer> countOfAnagrams = getCount(s, p);
		System.out.println(countOfAnagrams);
	}

	private static List<Integer> getCount(String str, String ptr) {

		List<Integer> result = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < ptr.length(); i++) {
			Character key = ptr.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int count = map.size();
		// System.out.println(map);

		int i = 0;
		int j = 0;

		while (j < str.length()) {

			Character key = str.charAt(j);

			if (map.containsKey(key)) {

				map.put(key, map.get(key) - 1);

				if (map.get(key) == 0) {
					count--;
				}
			}

			if (j - i + 1 == ptr.length()) {

				if (count == 0) {
					result.add(i);
				}

				// now move the left index that is i

				Character key2 = str.charAt(i);

				if (map.containsKey(key2)) {

					if (map.get(key2) == 0) {
						count++;
					}
					map.put(key2, map.get(key2) + 1);
				}

				i++;

			}

			j++;

		}

		return result;
	}
}