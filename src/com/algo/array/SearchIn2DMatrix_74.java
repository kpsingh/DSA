package com.algo.array;

public class SearchIn2DMatrix_74 {

	public static void main(String[] args) {

		int[][] arr = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

		boolean result = searchMatrix(arr, 20);
		System.out.println(result);

	}

	public static boolean searchMatrix(int[][] arr, int target) {

		int noOfRow = arr.length; // no of rows - 3
		int noOfCol = arr[0].length; // no of colums - 4

		int low = 0; // valid
		int high = noOfRow * noOfCol; // pointing to non valid answer

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			int row = mid / noOfCol;
			int col = mid % noOfCol;

			if (ok(arr, row, col, target)) {
				low = mid;
			} else {
				high = mid;
			}

		}

		return arr[low / noOfCol][low % noOfCol] == target ? true : false;

	}

	private static boolean ok(int[][] arr, int row, int col, int target) {

		return arr[row][col] <= target;
	}

}
