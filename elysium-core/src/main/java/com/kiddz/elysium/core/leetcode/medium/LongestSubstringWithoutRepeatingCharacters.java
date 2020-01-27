package com.kiddz.elysium.core.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = " ";
        int result = lengthOfLongestSubstringOptimized(str);
        System.out.println(result);
    }

    private static int lengthOfLongestSubstring(String s) {
        int result = 0;
        int i = 0;
        int j = 0;
        int length = s.length();
        Set<Character> tmp = new HashSet<>();
        while (i < length && j < length) {
            char character = s.charAt(j);
            if (!tmp.contains(character)) {
                tmp.add(character);
                j++;
                result = Math.max(result, j - i);
            } else {
                tmp.remove(s.charAt(i++));
            }
        }
        return result;
    }

    private static int lengthOfLongestSubstringOptimized(String s) {
        int result = 0;
        int length = s.length();
        int start = 0;
        Map<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char character = s.charAt(i);
            if (tmp.containsKey(character)) {
                if (tmp.get(character) >= start) {
                    start = tmp.get(character) + 1;
                }
            }
            tmp.put(character, i);
            result = Math.max(result, i - start + 1);
        }
        return result;
    }
}
