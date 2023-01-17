package com.algo.twopointers;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInWindowOfK {
	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int w = 3;

		printFirstNegative(arr, w);

	}

	private static void printFirstNegative(int[] arr, int w) {

		List<Integer> list = new ArrayList<>();

		int i = 0;

		while (i < arr.length) {

			if (list.size() < w) {
				list.add(arr[i]);
				i++;

			} else {
				for (int a : list) {
					if (a < 0) {
						System.out.println(a);
						break;
					}
				}
				list.remove(0);
				list.add(arr[i]);
				i++;

			}
		}

	}

}
