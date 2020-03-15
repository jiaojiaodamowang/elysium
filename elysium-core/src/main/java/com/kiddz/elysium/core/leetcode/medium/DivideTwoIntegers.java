package com.kiddz.elysium.core.leetcode.medium;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example,
 * truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Explanation: 10/3 = truncate(3.33333..) = truncate(3) = 3.
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Explanation: 7/-3 = truncate(-2.33333..) = truncate(-2) = 3.
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 2^31 − 1 when
 * the division result overflows.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        int dividend1 = 10;
        int divisor1 = 3;
        int dividend2 = 7;
        int divisor2 = -3;
        int dividend3 = 1;
        int divisor3 = 1;
        int dividend4 = -2147483648;
        int divisor4 = -1;
        System.out.println(divide(dividend1, divisor1));
        System.out.println(divide(dividend2, divisor2));
        System.out.println(divide(dividend3, divisor3));
        System.out.println(divide(dividend4, divisor4));
    }

    private static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res = div(-Math.abs(dividend), -Math.abs(divisor));
        return (dividend ^ divisor) >= 0 ? res : -res;
    }

    private static int div(int dividend, int divisor) {
        if (dividend > divisor) {
            return 0;
        }
        int sum = divisor;
        int count = 1;
        while (dividend <= (sum << 1) && (sum << 1) < 0) {
            sum <<= 1;
            count <<= 1;
        }
        return count + div(dividend - sum, divisor);
    }
}
