package com.algo.recusrsion;

import java.util.Arrays;

public class SortArrray {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 5 };
		sort(arr, arr.length);
		Arrays.toString(arr);
	}

	private static void sort(int[] arr, int size) {

		if (size == 1) {
			return;
		}

		sort(arr, size--);
		
		
		
		

	}

}
