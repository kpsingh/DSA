package com.algo.misc;

public class RomanToInteger {

	public static void main(String[] args) {

		String str = "XXIII"; // XXIII, MCMIV

		int result = convertToInteger(str);

		System.out.println("MCMIV --> " + result);

	}

	private static int convertToInteger(String str) {
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

}
