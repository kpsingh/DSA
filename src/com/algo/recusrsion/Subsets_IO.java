package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class Subsets_IO {

	static List<String> subsets = new ArrayList<>();

	public static void main(String[] args) {

		List<String> input = new ArrayList<>();
		input.add("a");
		input.add("b");
		input.add("c");

		String output = "";

		printSubsets(input, output);

		for (String s : subsets) {
			System.out.println(s);
		}

	}

	private static void printSubsets(List<String> input, String output) {

		if (input.size() == 0) {
			subsets.add(output);
			return;
		}

		String output_1 = output;
		String output_2 = output + input.get(0);
		List<String> newInput = new ArrayList<>(input);
		newInput.remove(0);

		printSubsets(newInput, output_1);
		printSubsets(newInput, output_2);

	}

}
