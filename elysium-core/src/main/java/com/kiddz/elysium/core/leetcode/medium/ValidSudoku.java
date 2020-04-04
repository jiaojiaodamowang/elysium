package com.kiddz.elysium.core.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 *
 * Input:
 * [
 *   ['5','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: true
 *
 * Example 2:
 *
 * Input:
 * [
 *   ['8','3','.','.','7','.','.','.','.'],
 *   ['6','.','.','1','9','5','.','.','.'],
 *   ['.','9','8','.','.','.','.','6','.'],
 *   ['8','.','.','.','6','.','.','.','3'],
 *   ['4','.','.','8','.','3','.','.','1'],
 *   ['7','.','.','.','2','.','.','.','6'],
 *   ['.','6','.','.','.','.','2','8','.'],
 *   ['.','.','.','4','1','9','.','.','5'],
 *   ['.','.','.','.','8','.','.','7','9']
 * ]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board1 = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board1));
        System.out.println(isValidSudoku(board2));
    }

    private static boolean isValidSudoku(char[][] board) {
        Set<Character> rowDict = new HashSet<>();
        Map<Integer, Set<Character>> colDict = new HashMap<>();
        Map<Integer, Set<Character>> subBoardDict = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            colDict.put(i, new HashSet<>());
            subBoardDict.put(i, new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if ('.' == board[row][col]) {
                    continue;
                }
                if (rowDict.contains(board[row][col])) {
                    return false;
                } else {
                    rowDict.add(board[row][col]);
                }
                if (colDict.get(col).contains(board[row][col])) {
                    return false;
                } else {
                    colDict.get(col).add(board[row][col]);
                }
                int index = getIndex(row, col);
                if (subBoardDict.get(index).contains(board[row][col])) {
                    return false;
                } else {
                    subBoardDict.get(index).add(board[row][col]);
                }
            }
            rowDict.clear();
        }
        return true;
    }

    private static int getIndex(int row, int col) {
        if (row < 3 && col < 3) {
            return 0;
        } else if (row < 3 && col < 6) {
            return 1;
        } else if (row < 3 && col < 9) {
            return 2;
        } else if (row < 6 && col < 3) {
            return 3;
        } else if (row < 6 && col < 6) {
            return 4;
        } else if (row < 6 && col < 9) {
            return 5;
        } else if (row < 9 && col < 3) {
            return 6;
        } else if (row < 9 && col < 6) {
            return 7;
        } else {
            return 8;
        }
    }
}
