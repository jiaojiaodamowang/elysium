package com.kiddz.elysium.core.leetcode.easy;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 *
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        System.out.println(removeElement(nums, val));
        System.out.println(removeElement(nums2, val2));
    }

    private static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
