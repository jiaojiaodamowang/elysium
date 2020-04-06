package com.kiddz.elysium.core.leetcode.medium;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively,
 * in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 *
 *
 * Example 1:
 *
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 *
 * Example 2:
 *
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12"
 * which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation
 * of "12" and "11" which is "1211".
 */
public class CountAndSay {

    public static void main(String[] args) {
        int n1 = 1;
        System.out.println(countAndSay(n1));
        int n2 = 4;
        System.out.println(countAndSay(n2));
    }

    private static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        int len = str.length();
        StringBuilder result = new StringBuilder();
        int count = 1;
        char last = str.charAt(0);
        for (int i = 1; i < len; i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                result.append(count).append(last);
                last = str.charAt(i);
                count = 1;
            }
        }
        result.append(count).append(last);
        return result.toString();
    }
}
