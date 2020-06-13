package com.kiddz.elysium.core.leetcode.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10^4
 * 0 <= nums[i][j] <= 10^5
 */
public class JumpGame {

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int current = 0;
        int end = nums.length - 1;
        while (current < end) {
            int maxStep = nums[current];
            if (maxStep == 0) {
                return false;
            }
            if (current + maxStep >= end) {
                return true;
            }
            int next = current;
            int max = 0;
            for (int i = 1; i <= maxStep; i++) {
                if (nums[current + i] + current + i >= max) {
                    next = current + i;
                    max = nums[current + i] + current + i;
                }
            }
            current = next;
        }
        return true;
    }

    private static boolean canJump2(int[] nums) {
        int lenth = nums.length;
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= lenth - 1) {
                return true;
            }
        }
        return false;
    }
}
