package com.algo.misc;

import java.util.ArrayList;
import java.util.List;

public class Roman {

	public static void main(String[] args) {

		Roman roman = new Roman();

		// XXIII -- 23, MCMIV - 1904

		System.out.println("DCCCCXXXXV --> " + roman.romanToInteger("DCCCCXXXXV"));

		System.out.println("945 --> " + roman.intToRoman(945));

	}

	private int romanToInteger(String str) {
		int result = 0;

		for (int i = 0; i < str.length(); i++) {

			int s1 = getDecimal(str.charAt(i));

			if (i + 1 < str.length()) {
				/**
				 * this mean current char at "i" is not the last char, we need to check the
				 * value of next chart. If value of char "i" is greater that value of chart at
				 * "i+1" then we can simply add the value but if its less than next then we need
				 * to add the greater value and subtract the less value from the final result.
				 * 
				 */

				int s2 = getDecimal(str.charAt(i + 1));

				if (s1 >= s2) {
					result = result + s1;
				} else {
					result = result + s2 - s1;
					i++; // since now we covered the i and i+1, hence final i need to move by 2
				}

			} else {
				/*
				 * that mean it is last character from the string and we don't have to check the
				 */
				result = result + s1;
			}

		}

		return result;
	}

	private static int getDecimal(char c) {

		if (c == 'I')
			return 1;
		if (c == 'V')
			return 5;
		if (c == 'X')
			return 10;
		if (c == 'L')
			return 50;
		if (c == 'C')
			return 100;
		if (c == 'D')
			return 500;
		if (c == 'M')
			return 1000;

		return -1;

	}

	/**
	 * Integer to Roman
	 * 
	 * https://leetcode.com/problems/integer-to-roman/
	 * 
	 * This will not work for for number more than 1000, need to modify program to
	 * solve for more than 1000
	 * 
	 */

	public String intToRoman(int num) {

		List<RomanNode> list = getList(); // input ready for key and value

		String result = "";

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {

			int key = list.get(start).key;

			if (key <= num) {

				start++;

			} else {
				key = list.get(start - 1).key;
				result = result + list.get(start - 1).val;

				num = num - key;

				if (num == 0) {
					break;
				}
				start = 0;
			}

		}

		return result;

	}

	class RomanNode {
		int key;
		String val;

		public RomanNode(int key, String val) {
			this.key = key;
			this.val = val;
		}

	}

	private List<RomanNode> getList() {

		List<RomanNode> list = new ArrayList<>();
		list.add(new RomanNode(1, "I"));
		list.add(new RomanNode(5, "V"));
		list.add(new RomanNode(10, "X"));
		list.add(new RomanNode(50, "L"));
		list.add(new RomanNode(100, "C"));
		list.add(new RomanNode(500, "D"));
		list.add(new RomanNode(1000, "M"));

		return list;
	}

}
