package com.kiddz.elysium.core.leetcode.easy;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        int x = 10;
        System.out.println(isPalindrome(x));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int originalNumber = x;
        long reversedNumber = 0L;
        while (x != 0) {
            reversedNumber = reversedNumber * 10 + x % 10;
            if (reversedNumber > Integer.MAX_VALUE) {
                return false;
            }
            x /= 10;
        }
        return originalNumber == (int) reversedNumber;
    }
}
