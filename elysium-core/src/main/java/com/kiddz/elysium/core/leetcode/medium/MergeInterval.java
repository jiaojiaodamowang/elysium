package com.kiddz.elysium.core.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);
        int[][] intervals2 = {{1, 4}, {4, 5}};
        merge(intervals2);
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] array) -> array[0]));
        int count = intervals.length;
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < count) {
            int[] tmp = intervals[i];
            while (i + 1 < count && tmp[1] >= intervals[i + 1][0]) {
                tmp[1] = Math.max(tmp[1], intervals[i + 1][1]);
                i++;
            }
            result.add(tmp);
            i++;
        }
        int[][] res = new int[result.size()][2];
        for (int j = 0; j < result.size(); j++) {
            res[j] = result.get(j);
        }
        return res;
    }

    private int[][] merge2(int[][] intervals) {
        int count = intervals.length;
        if (count == 0) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt((int[] array) -> array[0]));
        List<int[]> result = new ArrayList<>();
        result.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < count; i++) {
            int first = intervals[i][0];
            int second = intervals[i][1];

            int[] last = result.get(result.size() - 1);
            if (last[0] <= first && first <= last[1]) {
                last[1] = Math.max(last[1], second);
            } else {
                result.add(new int[]{first, second});
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
