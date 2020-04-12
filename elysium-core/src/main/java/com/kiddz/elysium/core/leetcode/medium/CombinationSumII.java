package com.kiddz.elysium.core.leetcode.medium;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class CombinationSumII {

    public static void main(String[] args) {
        int[] candidates1 = {10, 1, 2, 7, 6, 1, 5};
        int target1 = 8;
        int[] candidates2 = {2, 5, 2, 1, 2};
        int target2 = 5;
        System.out.println(combinationSum2(candidates1, target1));
        System.out.println(combinationSum2(candidates2, target2));
    }

    private static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> combo = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        backtracking(candidates, target, 0, combo, res);
        return new ArrayList<>(res);
    }

    private static void backtracking(int[] candidates, int target, int start, List<Integer> combo, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        int len = candidates.length;
        for (int i = start; i < len; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                return;
            }
            combo.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, combo, res);
            combo.remove(combo.size() - 1);
        }
    }
}
