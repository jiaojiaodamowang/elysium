package com.kiddz.elysium.core.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target1 = 8;
        int target2 = 6;
        System.out.println(Arrays.toString(searchRange(nums, target1)));
        System.out.println(Arrays.toString(searchRange(nums, target2)));
    }

    private static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) {
                int i = mid;
                int j = mid;
                while (i > start && nums[i - 1] == target) {
                    i--;
                }
                while (j < end && nums[j + 1] == target) {
                    j++;
                }
                return new int[]{i, j};
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}
