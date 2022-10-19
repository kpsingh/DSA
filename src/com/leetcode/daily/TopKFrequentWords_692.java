package com.leetcode.daily;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/top-k-frequent-words/
 */

public class TopKFrequentWords_692 {

	public static void main(String[] args) {
		// String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
		String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
		int k = 4;

		List<String> topKFrequent = topKFrequent(words, k);

		topKFrequent.forEach(s -> System.out.println(s));
	}

	public static List<String> topKFrequent(String[] words, int k) {

		Map<String, Integer> map = new TreeMap<>();

		for (String s : words) {
			map.merge(s, 1, (v1, v2) -> v1 + v2);

		}

		return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(k)
				.map(e -> e.getKey()).collect(Collectors.toList());

	}
}
