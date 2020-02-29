package com.kiddz.elysium.core.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        int n = 3;
        List<String> result = generateParenthesis(n);
        System.out.println(result);
    }

    private static List<String> generateParenthesis(int n) {
        String str = "";
        List<String> res = new LinkedList<>();
        backtrack(res, str, n, n);
        return res;
    }

    private static void backtrack(List<String> res, String str, int open, int close) {
        if (close == 0) {
            res.add(str);
            return;
        }
        if (open > 0) {
            backtrack(res, str + "(", open - 1, close);
        }
        if (close > open) {
            backtrack(res, str + ")", open, close - 1);
        }
    }
}
