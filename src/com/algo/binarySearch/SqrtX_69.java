package com.algo.binarySearch;

public class SqrtX_69 {
	
	public int mySqrt(int x) {

		if (x == 0) {
			return 0;
		}

		int low = 1;
		int high = x;

		while (low + 1 < high) {

			int mid = low + (high - low) / 2;

			if (ok(x, mid)) {

				low = mid; // more responsibility to low, hence finally returning it. (close to lowest integer)

			} else {
				high = mid;
			}
		}

		return low;
	}

	private boolean ok(int n, int mid) {
		return mid <= n / mid; // mid * mid <= n
	}
}
