package com.kiddz.elysium.core.leetcode.easy;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part
 * of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SqrtX {

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt(x));
        System.out.println(mySqrt2(x));
    }

    private static int mySqrt(int x) {
        int i = 0;
        int square = 0;
        while (square <= x) {
            i++;
            square = i * i;
            if (square < 0) {
                break;
            }
        }
        return i - 1;
    }

    private static int mySqrt2(int x) {
        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
