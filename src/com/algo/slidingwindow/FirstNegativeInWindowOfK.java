package com.algo.slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * https://www.geeksforgeeks.org/first-negative-integer-every-window-size-k/
 * 
 * 
 */
import java.util.List;
import java.util.Queue;

import org.w3c.dom.ls.LSOutput;

public class FirstNegativeInWindowOfK {
	public static void main(String[] args) {
		int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
		int w = 3;

		printFirstNegative(arr, w);
		
		System.out.println("**************");

		printFirstNegativeRevision(arr, w);

	}

	private static void printFirstNegativeRevision(int[] arr, int w) {

		if (arr.length < w) {
			System.out.println("Invalid input");
		}

		List<Integer> ansList = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();

		int left = 0;
		int right = 0;

		while (right < arr.length) {

			int element = arr[right];

			if (element < 0) {
				que.offer(element);
			}

			if (right - left + 1 == w) {

				if (que.size() == 0) {
					ansList.add(0);
				} else {
					ansList.add(que.peek());
					if (arr[left] == que.peek()) {
						que.poll();
					}
				}

				left++;
			}

			right++;
		}

		for (int a : ansList) {
			System.out.print(a + " ");
		}

		// ansList.stream().mapToInt(e -> e).forEach(System.out.prinln(e.));
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
					System.out.print(list.get(0) + " ");

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
