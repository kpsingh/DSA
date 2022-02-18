package com.algo.binarySearch.learning;

public class AgnosticBinarySearch {
    public static void main(String[] args) {

        // int arr[] = {1, 3, 4, 6, 15, 17, 23, 34, 45, 56, 78, 89};

        int[] arr = {45, 35, 25, 20, 9, 5, 3, -10, -20, -30};
        int key = 56;
        int index = agnosticBS(arr, key);
        System.out.println(index);
    }

    static int agnosticBS(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;

        // Check if given array is in ascending order or in descending order
        boolean isAsc = arr[start] < arr[end];
        if (isAsc) {
            System.out.println("Ascending order...");
        } else {
            System.out.println("Descending order...");
        }
        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            if (isAsc) {
                if (arr[mid] < key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (arr[mid] > key) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }

        return -1;
    }
}