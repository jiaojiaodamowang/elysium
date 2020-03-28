package com.kiddz.elysium.core.leetcode.medium;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        int target1 = 0;
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        int target2 = 3;
        int[] nums3 = {1, 3};
        int target3 = 0;
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        int target4 = 4;
        System.out.println(search(nums1, target1));
        System.out.println(search(nums2, target2));
        System.out.println(search(nums3, target3));
        System.out.println(search(nums4, target4));
    }

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == nums[start]) {
                return start;
            } else if (target == nums[end]) {
                return end;
            } else if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] < nums[end]) {
                if (target > nums[mid] && target < nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] < nums[mid]) {
                if (target > nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                return -1;
            }
        }
        return -1;
    }
}

