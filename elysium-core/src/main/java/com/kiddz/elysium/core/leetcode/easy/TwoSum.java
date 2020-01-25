package com.kiddz.elysium.core.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        try {
            twoSum(nums, target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int[] twoSum(int[] nums, int target) throws Exception {
        Map<Integer, Integer> dict = new HashMap<>();
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            int res = target - nums[i];
            if (dict.containsKey(res)) {
                return new int[]{i, dict.get(res)};
            }
            dict.put(nums[i], i);
        }
        throw new Exception("no results");
    }
}
