package com.kiddz.elysium.core.leetcode.medium;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "babad";
        String s2 = "abbc";
        String s3 = "bb";
        String res = longestPalindrome(s2);
        System.out.println(res);
    }

    private static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return "";
        }
        int start = 0;
        int end = 1;
        int size = s.length();
        for (int i = 0; i < size; i++) {
            int len = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            len = (len > len2) ? len : len2;
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left)==s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

}
