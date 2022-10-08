package com.algo.learning;
// ref : https://www.youtube.com/watch?v=W9QJ8HaRvJQ&list=PPSV

public class CeilingNumber {
    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 9, 15, 18, 24, 29};
        int key = 12;
        System.out.println(getCeilingNumber(arr, key));
    }

    public static int getCeilingNumber(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        // if the given key is greater than all the elements of array then return -1
        if (arr[end] < key) {
            return -1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // if no element found and while loop breaks that mean element is not in array and ceil of it now 
        // reside in index of start
        return start;

        /*
        return end;

        if we return the 'end' then we are returning the flor element, because when while loop termination condition met
        that time end < start, that mean flore at left and ceil at right
         */

    }

}