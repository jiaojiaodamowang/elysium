package com.kiddz.elysium.core.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * 1 <= n <= 20
 * 1 <= k <= n
 */
public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    private static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        backTracking(n, k, 1, tmp, result);
        return result;
    }

    private static void backTracking(int n, int k, int index, List<Integer> tmp, List<List<Integer>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = index; i <= n; i++) {
            tmp.add(i);
            backTracking(n, k - 1, ++index, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }
}
