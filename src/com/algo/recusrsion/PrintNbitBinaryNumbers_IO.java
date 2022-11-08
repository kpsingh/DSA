package com.algo.recusrsion;
/*
 * Print the n digit binary number in such a way that number of 1's are >= 0's.
 * 
 * In order to make the decision tree, if both are same then the only way to start is choose the 1
 * and then you can have option to chose either of zero or one.
 * 
 * 
 */

public class PrintNbitBinaryNumbers_IO {

	public static void main(String[] args) {
		int n = 4;
		int one = 0;
		int zero = 0;

		// since number of i's has to be always >= 0's hence initialize the output from
		// 1.
		String output = "1";

		generateOneAndZero(n - 1, one + 1, zero, output);

	}

	private static void generateOneAndZero(int n, int one, int zero, String output) {

		if (n == 0) {
			System.out.println(output);
			return;
		}

		if (one == zero) {
			// got only once choice but to add the 1 in output.

			String op1 = output + "1";
			generateOneAndZero(n - 1, one + 1, zero, op1);

		} else {
			// we can either 1 or 0, as number of 0 not going to exceed the number of 1
			String op1 = output + "1";
			String op2 = output + "0";

			generateOneAndZero(n - 1, one + 1, zero, op1);
			generateOneAndZero(n - 1, one, zero + 1, op2);

		}

	}

}
