package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.youtube.com/watch?v=1cspuQ6qHW0&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14
 */

public class PermutationWithSpaces_IO {

	public static void main(String[] args) {

		List<String> input = new ArrayList<>();
		input.add("A");
		input.add("B");
		input.add("C");

		String output = input.get(0);
		input.remove(0);

		printPermuWithSpace(input, output);
	}

	private static void printPermuWithSpace(List<String> input, String output) {
		if (input.size() == 0) {
			System.out.println(output);
			return;
		}

		String element = input.get(0); // get the element from original input

		String output1 = output + element;
		String output2 = output + "_" + element;

		List<String> newInput = new ArrayList<>(input);

		newInput.remove(0); // new input will not have same element which been added in above

		printPermuWithSpace(newInput, output1);
		printPermuWithSpace(newInput, output2);

	}

}
