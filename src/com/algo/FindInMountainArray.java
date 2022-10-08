package com.algo;
/*
https://leetcode.com/problems/find-in-mountain-array/

https://leetcode.com/problems/find-in-mountain-array/submissions/

 */

public class FindInMountainArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 1};
        int target = 3;
        int ans = findInMountainArray(target, arr);
        System.out.println(ans);
    }
    public static int findInMountainArray(int target, int[] arr) {

        // get the index of peak element and search in the left and right of that element
        // left side will be asc and right side will be desc i.e.  Order Agnostic Binary Search

        int peak = findPeak(arr);

        /*
        In this case the both start and end are pointing to the same index and how we have to check if element
        is present here or not. Now the target element may exist in increasing array or ion decreasing array. we need to find.
        */

        int asc = agnosticBS(arr, target, 0, peak, true);

        if (asc != -1) {
            return asc;
        }
        // if element not found in asc array then search in desc
        return agnosticBS(arr, target, peak, arr.length - 1, false);
    }

    private static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        return start;
    }

    static int agnosticBS(int[] arr, int key, int start, int end, boolean isAsc) {

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
