package com.kiddz.elysium.core.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number
 * could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map
 * to any letters.
 *
 * (2, "abc");
 * (3, "def");
 * (4, "ghi");
 * (5, "jkl");
 * (6, "mno");
 * (7, "pqrs");
 * (8, "tuv");
 * (9, "wxyz");
 */
public class LetterCombinationsOfAPhoneNumber {

    private static Map<String, String> dials = new HashMap<>();
    static {
        dials.put("2", "abc");
        dials.put("3", "def");
        dials.put("4", "ghi");
        dials.put("5", "jkl");
        dials.put("6", "mno");
        dials.put("7", "pqrs");
        dials.put("8", "tuv");
        dials.put("9", "wxyz");
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) {
            return res;
        }
        backtracking(res, "", digits);
        return res;
    }

    private static void backtracking(List<String> res, String combination, String remainingDigits) {
        if (remainingDigits.length() == 0) {
            res.add(combination);
            return;
        }
        String num = remainingDigits.substring(0, 1);
        String letters = dials.get(num);
        for (int i = 0; i < letters.length(); i++) {
            String letter = letters.substring(i, i + 1);
            backtracking(res, combination + letter, remainingDigits.substring(1));
        }
    }
}
