package com.algo.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets_904 {

	public static void main(String[] args) {

		// int[] arr = { 0 };
		// int[] arr = { 0 };
		int[] arr = { 0, 1, 2, 2 };
		// int[] arr = { 0 };
		System.out.println(totalFruit(arr));

	}

	public static int totalFruit(int[] arr) {
		if (arr.length <= 2) {
			return arr.length; // if <= 2 then that is the option
		}
		int result = 2; // if more than two then this is minimum answer can be
		int i = 0;
		int j = 0;
		Map<Integer, Integer> map = new HashMap<>();

		while (j < arr.length) {
			int key = arr[j];

			if (map.size() < 2 || map.containsKey(key)) {
				map.put(key, map.getOrDefault(key, 0) + 1);
				result = Math.max(result, j - i + 1);
				j++;
			} else {
				while (map.size() >= 2) {
					int removeKey = arr[i];
					map.put(removeKey, map.get(removeKey) - 1);
					if (map.get(removeKey) == 0) {
						{
							map.remove(removeKey);
						}
					}
					i++;
				}
			}

		}
		return result;
	}

}
