package com.algo.misc;

public class RomanToDecimal {

	public static void main(String[] args) {

		String str = "MCMIV";

		int result = convertToDecimal(str);

		System.out.println("MCMIV --> " + result);

	}

	private static int convertToDecimal(String str) {

		int result = 0;

		for (int i = 0; i < str.length(); i++) {

			int s1 = value(str.charAt(i));

			if (i + 1 < str.length()) {

				int s2 = value(str.charAt(i + 1));

				if (s1 >= s2) {

					result = result + s1;

				} else {

					result = result + s2 - s1;
					i++;
				}

			} else {

				result = result + s1;
			}

		}

		return result;
	}

	private static int value(char c) {

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
