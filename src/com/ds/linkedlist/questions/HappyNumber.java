package com.ds.linkedlist.questions;

import java.util.HashSet;
import java.util.Set;

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

		Set<Integer> set = new HashSet<>();

		while (true) {

			set.add(n);

			n = getNext(n);

			if (n == 1)
				return true;

			if (set.contains(n))
				return false;
			else
				set.add(n);

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
