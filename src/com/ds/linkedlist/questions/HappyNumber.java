package com.ds.linkedlist.questions;

import java.util.HashMap;

/*
https://leetcode.com/problems/happy-number/

https://leetcode.com/problems/happy-number/submissions/


 */
public class HappyNumber {

	public static void main(String[] args) {

		HappyNumber hn = new HappyNumber();
		boolean isHappy = hn.isHappy(19);
		System.out.println(isHappy);

	}

	public boolean isHappy(int n) {

		if (n == 0)
			return false;

		HashMap<Integer, Boolean> map = new HashMap<>();

		while (true) {

			map.put(n, true);

			n = getNext(n);

			if (n == 1)
				return true;

			if (map.containsKey(n))
				return false;
			else
				map.put(n, true);

		}

	}

	private int getNext(int n) {

		int ans = 0;

		while (n != 0) {
			int r = n % 10;
			ans = ans + (r * r);
			n = n / 10;
		}

		return ans;
	}

}
