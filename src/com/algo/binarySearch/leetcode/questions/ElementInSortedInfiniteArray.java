package com.algo.binarySearch.leetcode.questions;

/*
https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

Since it says elements are infinite that mean we should not use the arr.length function instead find a alternate mechanism.
We should use the sliding window kind things. we define a window and of element not in range then we'll double the range...
its kind of reverse of Binary search...

 */
public class ElementInSortedInfiniteArray {

    public static void main(String[] args) {

        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findElement(arr, 10);

        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index : " + ans);

    }

    private static int findElement(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int temp = end + 1;
            end = end + (end - start + 1) * 2;// double the window
            start = temp;
        }
        /*
        if we exit the while loop it mean we have found the start and end range where target element
        does exist. Now simply we can apply the binary search as we know the start and end index.
         */

        return binarySearch(arr, target, start, end);

    }

    private static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > arr[mid]) {
                start = mid + 1;
            } else if (target < arr[mid]) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}
