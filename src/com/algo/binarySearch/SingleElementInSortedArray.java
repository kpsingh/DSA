package com.algo.binarySearch;

import java.util.Arrays;
import java.util.List;

public class SingleElementInSortedArray {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(13, 13, 21, 21, 27, 50, 50, 102, 102, 108, 108, 110, 110, 117, 117, 120, 120,
				123, 123, 124, 124, 132, 132, 164, 164, 166, 166, 190, 190, 200, 200, 212, 212, 217, 217, 225, 225, 238,
				238, 261, 261, 276, 276, 347, 347, 348, 348, 386, 386, 394, 394, 405, 405, 426, 426, 435, 435, 474, 474,
				493, 493);
		int result = solve(list);
		System.out.println(result);

	}

	public static int solve(List<Integer> A) {
		int n = A.size();
		int low = 0;
		int hi = n - 1;
		int ans = -1;

		// Edge Cases
		if (n == 1)
			return A.get(0);
		if (A.get(0) != A.get(1))
			return A.get(0); // first element duplicate
		if (A.get(n - 1) != A.get(n - 2))
			return A.get(n - 1); // last element duplicate

		while (low <= hi) {
			int mid = low + (hi - low) / 2;

			if (A.get(mid) != A.get(mid - 1) && A.get(mid) != A.get(mid + 1)) {
				ans = mid;
				break;
			}
			if (mid % 2 == 0) {
				if (A.get(mid) == A.get(mid + 1)) {
					low = mid + 1;
				} else {
					hi = mid - 1;
				}
			} else {
				if (A.get(mid) == A.get(mid - 1)) {
					hi = mid - 1;
				} else {
					low = mid + 1;
				}
			}

		}
		return A.get(ans);
	}

}
