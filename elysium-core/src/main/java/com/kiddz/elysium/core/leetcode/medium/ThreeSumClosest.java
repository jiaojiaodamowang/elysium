package com.kiddz.elysium.core.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum
 * is closest to target. Return the sum of the three integers. You may assume that each input would have
 * exactly one solution.
 *
 * Example:
 *
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
//        int[] nums = {-1, 2, 1, -4};
//        int target = 1;
//        int[] nums = {0, 1, 2};
//        int target = 0;
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }

    private static int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        Arrays.sort(nums);
        int size = nums.length;
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < size - 2; i++) {
            int start = i + 1;
            int end = size - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
                if (sum > target) {
                    end--;
                    while (start < end && nums[end + 1] == nums[end]) {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                    while (start < end && nums[start - 1] == nums[start]) {
                        start++;
                    }
                }
            }
        }
        return result;
    }

}
