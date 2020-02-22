package com.kiddz.elysium.core.leetcode.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input
 * string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && (stack.empty() || '(' != stack.pop())) {
                return false;
            } else if (c == ']' && (stack.empty() || '[' != stack.pop())) {
                return false;
            } else if (c == '}' && (stack.empty() || '{' != stack.pop())) {
                return false;
            }
        }
        return stack.empty();
    }
}
