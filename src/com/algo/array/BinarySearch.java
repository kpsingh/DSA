package com.algo.array;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = {1, 3, 4, 6, 15, 17, 23, 34, 45, 56, 78, 89};
        int key = 78;

        System.out.println(itreBinarySearch(arr, key));
        System.out.println(recursiveBinarySearch(arr, key, 0, arr.length-1));

    }

    public static int itreBinarySearch(int[] arr, int key) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
       /*
        int mid = (start + end) / 2; this will may cause the int out of range in case start and end are very large.
        So we'll use the below method to avoid integer overflow: mid = start + (end - start)/2
        */

            int mid = start + (end - start) / 2;

            if (arr[mid] == key) {
                return mid;

            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int recursiveBinarySearch(int[] arr, int key, int start, int end){

        if (start <= end){

            int mid = start + (end - start)/2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                return recursiveBinarySearch(arr, key, mid+1, end);
            else
                return recursiveBinarySearch(arr, key, start, mid-1);
        }
        return -1;
    }

}