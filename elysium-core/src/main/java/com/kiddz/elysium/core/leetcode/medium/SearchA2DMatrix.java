package com.kiddz.elysium.core.leetcode.medium;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
 * Output: false
 *
 * Example 3:
 * Input: matrix = [], target = 0
 * Output: false
 *
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 0 <= m, n <= 100
 * -10^4 <= matrix[i][j], target <= 10^4
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 3;
//        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
//        int target = 13;
//        int[][] matrix = {};
//        int target = 0;
//        int[][] matrix = {{}};
//        int target = 0;
//        int[][] matrix = {{1,1}};
//        int target = 0;
//        int[][] matrix = {{1,1}};
//        int target = 2;
        System.out.println(searchMatrix(matrix, target));
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int rowCount = matrix.length;
        if (rowCount == 0) {
            return false;
        }
        int colCount = matrix[0].length;
        if (colCount == 0) {
            return false;
        }
        if (rowCount == 1 && colCount == 1) {
            return matrix[rowCount - 1][colCount - 1] == target;
        }
        int rowStart = 0;
        int rowEnd = rowCount;
        while (rowStart < rowEnd) {
            int targetIndex = rowStart + (rowEnd - rowStart) / 2;
            int[] targetArray = matrix[targetIndex];
            int targetArrayStart = targetArray[0];
            int targetArrayEnd = targetArray[colCount - 1];
            if (target >= targetArrayStart && target <= targetArrayEnd) {
                return searchArray(targetArray, target);
            } else if (target < targetArray[0]) {
                rowEnd = targetIndex;
            } else {
                rowStart = targetIndex + 1;
            }
        }
        return false;
    }

    private static boolean searchArray(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return true;
            } else if (target < array[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
