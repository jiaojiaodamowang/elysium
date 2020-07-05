package com.kiddz.elysium.core.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word (last word means the last appearing word if we loop from left to right) in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a maximal substring consisting of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        String s = "hello world";
        System.out.println(lengthOfLastWord(s));
    }

    private static int lengthOfLastWord(String s ) {
        String[] words = s.split(" ");
        int lastIndex = words.length - 1;
        if (lastIndex < 0) {
            return 0;
        }
        return words[lastIndex].length();
    }
}
