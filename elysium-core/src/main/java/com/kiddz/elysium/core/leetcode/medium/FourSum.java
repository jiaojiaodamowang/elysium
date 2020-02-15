package com.kiddz.elysium.core.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * <p>
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2, 3};
        int target = 0;
        System.out.println(fourSum(nums2, target));
    }

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j++) {
                if (j - 1 > i && nums[j] == nums[j - 1]) {
                    continue;
                }
                int head = j + 1;
                int tail = length - 1;
                while (head < tail) {
                    int sum = nums[i] + nums[j] + nums[head] + nums[tail];
                    if (sum == target) {
                        List<Integer> array = new LinkedList<>();
                        array.add(nums[i]);
                        array.add(nums[j]);
                        array.add(nums[head]);
                        array.add(nums[tail]);
                        result.add(array);
                        head++;
                        while (head < tail && nums[head] == nums[head-1]) {
                            head++;
                        }
                        tail--;
                        while (head < tail && nums[tail] == nums[tail+1]) {
                            tail--;
                        }
                    } else if (sum < target) {
                        head++;
                    } else if (sum > target) {
                        tail--;
                    }
                }
            }
        }
        return result;
    }
}
