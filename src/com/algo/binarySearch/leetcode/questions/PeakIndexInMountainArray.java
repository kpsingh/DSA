package com.algo.binarySearch.leetcode.questions;
/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/

https://leetcode.com/problems/find-peak-element/

https://leetcode.com/problems/find-in-mountain-array/



1. First try to find a Brute Force Solution then the optimised version.
 */

public class PeakIndexInMountainArray {

    public static void main(String[] args) {

        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }


    public static int peakIndexInMountainArray(int[] arr) {
        {
            int start = 0;
            int end = arr.length - 1;

            while (start < end) {

                int mid = start + (end - start) / 2;

                if (arr[mid] < arr[mid + 1]) {
                    // that mean we are in increasing order
                    start = mid + 1;
                } else {
                    // in decreasing part of the array and may be the ans that is why end != mid -1;
                    end = mid;
                }

            }
            // start and end are equal that mean they are pointing to the largest element in the array. Dry run the above two
            // condition, and you will, able to see this.
            if (start == end) {
                return start;
            } else {
                return -1;
            }

        }
    }

    /* This is a brute force solution.

    private static int maxNumber(int[] arr) {
        int max = 0;
        for (int x : arr) {
            if (x > max) {
                max = x;
            }
        }
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                index = i;
                break;
            }
        }

        return index;
    }*/


}
