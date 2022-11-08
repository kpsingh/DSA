package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubsets_78 {

	static List<List<Integer>> subsets = new ArrayList<>();

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3 };

		subsets(arr);

		for (List<Integer> set : subsets) {
			System.out.println(set);
		}

	}

	public static List<List<Integer>> subsets(int[] arr) {

		ArrayList<Integer> input = new ArrayList<>();
		for (int a : arr) {
			input.add(a);
		}

		ArrayList<Integer> output = new ArrayList<>();

		subsets(input, output);
		
		return subsets;

	}

	private static void subsets(ArrayList<Integer> input, ArrayList<Integer> output) {

		if (input.size() == 0) {
			subsets.add(new ArrayList<>(output));
			return;
		}

		ArrayList<Integer> output1 = new ArrayList<>(output);

		ArrayList<Integer> output2 = new ArrayList<>(output);
		output2.add(input.get(0));

		ArrayList<Integer> inputNew = new ArrayList<>(input);
		inputNew.remove(0);

		subsets(inputNew, output2);

		subsets(inputNew, output1);

	}

}
