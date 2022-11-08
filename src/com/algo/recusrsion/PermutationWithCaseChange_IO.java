package com.algo.recusrsion;
/*
 * https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15
 */

import java.util.ArrayList;
import java.util.List;

public class PermutationWithCaseChange_IO {

	public static void main(String[] args) {
		List<String> input = new ArrayList<>();
		input.add("a");
		input.add("b");
		// input.add("C");

		String output = "";

		permuteWithCaseChange(input, output);
	}

	private static void permuteWithCaseChange(List<String> input, String output) {

		if (input.size() == 0) {
			System.out.println(output);
			return;
		}

		String s = input.get(0);
		String op1 = output + s;
		String op2 = output + s.toUpperCase();

		List<String> newInput = new ArrayList<>(input);
		newInput.remove(0);

		permuteWithCaseChange(newInput, op1);
		permuteWithCaseChange(newInput, op2);

	}

}
