package com.algo.binarySearch;

import java.util.Arrays;
import java.util.List;

public class PaintersPartitionProblem {

	public static void main(String[] args) {
		int A = 1;
		int B = 1000000;
		List<Integer> C = Arrays.asList(1000000, 1000000);
		int result = paint(A, B, C);
		System.out.println(result);

	}

	public static int paint(int A, int B, List<Integer> C) {
		// for simplicity assume the time taken in 1 unit. so it will be size of all
		// element
		long low = Integer.MIN_VALUE; // max element in the arrays will be the minumum time
		long hi = 0; // sum of all element is the max time taken
		long ans = 0;

		for (int a : C) {
			low = Math.max(low, a);
			hi += a;
		}

		while (low <= hi) {
			long mid = low + (hi - low) / 2;
			if (ok(mid, A, C)) {
				ans = mid;
				hi = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return (int) ((ans * B) % 10000003);
	}

	private static boolean ok(long max, int A, List<Integer> C) {
		int count = 1;
		long sum = 0;
		for (int a : C) {
			if (sum + a <= max) {
				sum = sum + a;
			} else {
				count++;
				sum = a; // re-set teh sum again as new painter is started working
			}
			if (count > A) {
				return false; // with this time it is not possible to finish the work as more workers needed.
			}
		}

		return true; // if not false that mean it it possible to finish the task with this time
	}
}