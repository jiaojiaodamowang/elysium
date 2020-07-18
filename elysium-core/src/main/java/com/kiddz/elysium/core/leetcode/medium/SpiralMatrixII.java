package com.kiddz.elysium.core.leetcode.medium;

import java.util.Arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * <p>
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        int n = 3;
        int[][] matrix = generateMatrix(n);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print("(" + matrix[row][col] + ")");
            }
            System.out.println("\n");
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int leftBound = 0;
        int rightBound = n - 1;
        int upBound = 0;
        int downBound = n - 1;
        int value = 1;
        int max = n * n;
        while (value <= max) {
            for (int j = leftBound; j <= rightBound; j++) {
                matrix[upBound][j] = value++;
            }
            upBound++;
            for (int i = upBound; i <= downBound; i++) {
                matrix[i][rightBound] = value++;
            }
            rightBound--;
            for (int j = rightBound; j >= leftBound; j--) {
                matrix[downBound][j] = value++;
            }
            downBound--;
            for (int i = downBound; i >= upBound; i--) {
                matrix[i][leftBound] = value++;
            }
            leftBound++;
        }
        return matrix;
    }
}
