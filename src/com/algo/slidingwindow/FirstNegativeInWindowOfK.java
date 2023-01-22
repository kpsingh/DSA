package com.algo.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class FirstNegativeInWindowOfK {
	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int w = 3;

		printFirstNegative(arr, w);

	}

	private static void printFirstNegative(int[] arr, int w) {

		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();

		while (j < arr.length) {

			if (j - i + 1 < w) { // yet to be reach window size
				if (arr[j] < 0) {
					list.add(arr[j]);
				}
				j++;

			} else { // reached window size

				// add the element if -ve
				if (arr[j] < 0) {
					list.add(arr[j]);
				}

				// if list is empty then print the zero
				if (list.size() == 0) {
					System.out.println(0);
				} else { // otherwise print the very first element
					System.out.println(list.get(0));

				}

				if (arr[i] < 0) {
					list.remove(0);
				}
				i++;
				j++;

			}
		}

	}

}
