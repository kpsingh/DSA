package com.algo.recusrsion;

import java.util.ArrayList;
import java.util.List;

public class SortArrray {

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

		List<Integer> sort = sort(list);

		for (int a : sort) {
			System.out.print(a + " ");
		}
		System.out.println();

	}

	private static List<Integer> sort(List<Integer> list) {
		if (list.size() == 1) {
			return list;
		}

		int temp = list.get(list.size() - 1);

		List<Integer> subList = list.subList(0, list.size() - 1);

		subList = sort(subList);

		return merge(subList, temp);

	}

	private static List<Integer> merge(List<Integer> list, int target) {

		if (list.size() == 0 || list.get(list.size() - 1) <= target) {
			list.add(target);
			return list;
		}

		int temp = list.get(list.size() - 1);

		List<Integer> subLis = merge(list.subList(0, list.size() - 1), target);
		subLis.add(temp);
		return subLis;
	}

}
