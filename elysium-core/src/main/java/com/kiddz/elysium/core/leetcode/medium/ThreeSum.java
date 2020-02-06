package com.kiddz.elysium.core.leetcode.medium;

import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
//        int[] nums = {0, 0, 0, 0};
//        int[] nums = {-2, 0, 0, 2, 2};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        int size = nums.length;
        for (int i = 0; i < size && nums[i] <= 0; i++) {
            if (i - 1 >= 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int start = i + 1;
            int end = size - 1;
            while (start < end) {
                if (nums[start] + nums[end] < target) {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                } else if (nums[start] + nums[end] > target) {
                    end--;
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--;
                    }
                } else {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                    end--;
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
