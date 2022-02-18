package com.algo.binarySearch.leetcode.questions;

/*
https://leetcode.com/problems/valid-perfect-square/

https://leetcode.com/problems/sqrtx/

 */


public class IsPerfectSquare_367 {
    public static void main(String[] args) {
        int x = 25;
        System.out.println(isPerfectSquare(x));
        System.out.println(mySqrt(x));
    }


    //https://leetcode.com/problems/sqrtx/
    public static long mySqrt(int x) {
        long start = 0;
        long end = x;

        while (start <= end) {

            long mid = start + (end - start) / 2;

            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    // https://leetcode.com/problems/valid-perfect-square/
    public static boolean isPerfectSquare(int num) {

        int start = 0;
        int end = num;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;

    }
}
