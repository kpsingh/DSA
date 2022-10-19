package com.algo.array;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstAndLastPositionOfElement {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        //int[] nums = {};
        int target = 8;

        int[] ans = searchRange(nums, target);
        for (int a : ans) {
            System.out.print(a + "\n");
        }

    }

    public static int[] searchRange(int[] nums, int target) {

        int[] ans = {-1, -1};

        int start = BS(nums, target, true);
        int end = BS(nums, target, false);

        ans[0] = start;
        ans[1] = end;

        return ans;

    }

    private static int BS(int[] arr, int target, boolean isStartRange) {

        int start = 0;
        int end = arr.length - 1;

        int ans = -1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                // potential answer found
                ans = mid;

                if (isStartRange) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }

        }

        return ans;
    }
}