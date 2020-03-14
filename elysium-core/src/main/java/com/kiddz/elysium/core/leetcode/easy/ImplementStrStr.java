package com.kiddz.elysium.core.leetcode.easy;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr()
 * and Java's indexOf().
 */
public class ImplementStrStr {

    public static void main(String[] args) {
        String haystack1 = "hello";
        String needle1 = "ll";
        String haystack2 = "aaaaa";
        String needle2 = "bba";
        String haystack3 = "a";
        String needle3 = "a";
        System.out.println(strStr(haystack1, needle1));
        System.out.println(strStr(haystack2, needle2));
        System.out.println(strStr(haystack3, needle3));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        int last = haystack.length() - needle.length() + 1;
        int delta = needle.length();
        for (int i = 0; i < last; i++) {
            if (haystack.substring(i, i + delta).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
