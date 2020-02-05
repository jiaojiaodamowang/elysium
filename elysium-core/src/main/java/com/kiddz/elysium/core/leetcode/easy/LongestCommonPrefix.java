package com.kiddz.elysium.core.leetcode.easy;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("input:" + Arrays.toString(strs));
        System.out.println("output:" + longestCommonPrefix2(strs));
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("input:" + Arrays.toString(strs2));
        System.out.println("output:" + longestCommonPrefix2(strs2));

        System.out.println(longestCommonPrefix(strs2));
    }

    /**
     * horizontal scan
     *
     * @param strs
     * @return
     */
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String word = strs[i];
            while (word.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if ("".equals(prefix)) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * vertical scan
     *
     * @param strs
     * @return
     */
    private static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < prefix.length(); i++) {
            char character = prefix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != character) {
                    return prefix.substring(0, i);
                }
            }
        }
        return prefix;
    }

}
