package com.algo.binarySearch;

public class NumberOfRotation {
    public static void main(String[] args) {
       int[] arr = {12, 15, 18, 2, 3, 6};
      // int[] arr =  {7, 9, 11, 12, 15};

       System.out.println(findRotation(arr));

    }

    private static int findRotation(int[] arr){
        int peak = findPeak(arr);// index of pivot or peak index
        return peak +1;
    }

    private static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            if (arr[mid] >= arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }
}
