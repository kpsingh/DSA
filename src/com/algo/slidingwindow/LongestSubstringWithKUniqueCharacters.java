package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniqueCharacters {

	public static void main(String[] args) {

		String s = "aabacbebebebe";
		int k = 3;

		//String s = "aabbcc";
		//int k = 1;

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

			Character c = s.charAt(j);
			map.put(c, map.getOrDefault(c, 0) + 1);

			if (map.size() == k) {
				max = Math.max(max, j - i + 1);
			}

			while (map.size() > k) {
				Character c1 = s.charAt(i);
				map.put(c1, map.get(c1) - 1);
				if (map.get(c1) == 0) {
					map.remove(c1);
				}
				i++;
			}	
			j++;

		}

		return max;

	}

}
