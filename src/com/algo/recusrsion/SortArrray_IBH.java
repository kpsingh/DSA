package com.algo.recusrsion;

import java.util.ArrayList;

/*
 * Induction - Base - Hypothesis
 */

import java.util.List;

public class SortArrray_IBH {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(2);
		list.add(3);
		list.add(12);
		list.add(1);
		list.add(25);

		for (int a : list) {
			System.out.print(a + " ");
		}
		System.out.println();

		sort(list);

		for (int a : list) {
			System.out.print(a + " ");
		}
		System.out.println();

	}

	private static void sort(List<Integer> list) {
		if (list.size() == 1) {
			return;
		}

		int temp = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		sort(list);
		merge(list, temp);

	}

	private static void merge(List<Integer> list, int target) {

		if (list.size() == 0 || list.get(list.size() - 1) <= target) {
			list.add(target);
			return;
		}

		int temp = list.get(list.size() - 1);
		list.remove(list.size() - 1);

		merge(list, target);

		list.add(temp);

	}

}
