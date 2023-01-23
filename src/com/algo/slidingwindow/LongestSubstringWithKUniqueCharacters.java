package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {

		String s = "aabacbebebebe";
		int k = 3;

		int result = getLengthOfMaxSubstringK(s, k);

		System.out.println(result);
	}

	private static int getLengthOfMaxSubstringK(String s, int k) {

		if (s.length() < k || k == 0) {
			return 0;

		}

		int max = 0;
		int i = 0;
		int j = 0;
		
		Map<Character, Integer> map = new HashMap<>();

		while (j < s.length()) {

			Character key = s.charAt(j);

			if (map.size() < k) {

				map.put(key, map.getOrDefault(key, 0) + 1);

				j++;

			} else if (map.size() == k) {

				max = Math.max(max, j - i + 1); // a potential answer

				map.put(key, map.getOrDefault(key, 0) + 1);

				j++;

			} else if (map.size() > k) {

				while (map.size() < k) {

					Character key2 = s.charAt(i);
					map.put(key2, map.get(key2) - 1);

					if (map.get(key2) == 0) {
						map.remove(key2);
					}

					i++;

				}
				j++;

			}

		}

		return max;

	}

}
