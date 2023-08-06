package com.algo.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InversionCount {

	public static void main(String[] args) {

		List<Integer> asList = Arrays.asList(45, 10, 15, 25, 50);
		int result = solve(asList);
		System.out.println(result);
	}

	public static int solve(List<Integer> A) {
		return mergeSort(A, 0, A.size() - 1);
	}

	private static int mergeSort(List<Integer> A, int start, int end) {
		if (start == end) {
			return 0; // if single element then no inversion possible and array is already sorted
		}
		int mod = 1000 * 1000 * 1000 + 7;
		long count = 0;
		int mid = start + (end - start) / 2;

		count += mergeSort(A, start, mid); // sort the left half of the array and count the inversion
		count += mergeSort(A, mid + 1, end); // sort the right half of the array and count the inversion

		count += merge(A, start, mid + 1, end); // merge the left and right half the array and count the inversion

		return (int) count % mod;
	}

	private static int merge(List<Integer> A, int start, int mid, int end) {

		ArrayList<Integer> result = new ArrayList<>(); // temporary store the sorted data from start to end
		int n = mid - 1;
		int m = end;

		int i = start;
		int j = mid;
		int count = 0;

		while (i <= n && j <= m) {
			if (A.get(i) <= A.get(j)) {
				result.add(A.get(i));
				i++;
			} else {
				count += n - i + 1;
				result.add(A.get(j));
				j++;
			}
		}

		while (i <= n) {
			result.add(A.get(i++));
		}
		while (j <= m) {
			result.add(A.get(j++));
		}

		// updating the original array as sorted
		for (int k = 0; k < result.size(); k++) {
			A.set(k + start, result.get(k));
		}

		return count;
	}
}
