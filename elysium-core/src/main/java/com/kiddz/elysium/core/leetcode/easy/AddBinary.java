package com.kiddz.elysium.core.leetcode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Constraints:
 *
 * Each string consists only of '0' or '1' characters.
 * 1 <= a.length, b.length <= 10^4
 * Each string is either "0" or doesn't contain any leading zero.
 * Accepted
 */
public class AddBinary {

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitalA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitalB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitalA + digitalB + carry;
            carry = sum > 1 ? 1 : 0;
            if (sum <= 1) {
                sb.insert(0, sum);
            } else if (sum == 2) {
                sb.insert(0, 0);
            } else if (sum == 3) {
                sb.insert(0, 1);
            }
        }
        if (carry == 1) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }
}
