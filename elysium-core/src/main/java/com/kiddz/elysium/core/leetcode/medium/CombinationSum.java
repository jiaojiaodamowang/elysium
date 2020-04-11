package com.kiddz.elysium.core.leetcode.medium;

import javax.swing.*;
import java.util.*;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 *
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(combinationSum(candidates1, target1));
        System.out.println(combinationSum(candidates2, target2));
    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        List<Integer> combo = new ArrayList<>();
        backtracking(candidates, target, 0, combo, res);
        return res;
    }

    private static void backtracking(int[] candidates, int target, int start, List<Integer> combo, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(combo));
            return;
        }
        int len = candidates.length;
        for (int i = start; i < len; i++) {
            if (candidates[i] > target) {
                return;
            }
            combo.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i, combo, res);
            combo.remove(combo.size() - 1);
        }
    }
}
