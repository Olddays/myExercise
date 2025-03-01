package com.liu.LeetCode.CodeCaprice.BackTracking;

import java.util.List;

public class LC037_SudokuSolver {
    // 在N皇后的基础上进行拓展，N皇后是要看横、竖、斜是否有Q，这里是判断每个的横、竖、斜是否有1-9的某个数字
    // Beats 34.65%
    private static void solveSudokuMy1(char[][] board) {
        backtrackMy1(board, 0, 0);
    }

    private static boolean backtrackMy1(char[][] board, int row, int column) {
        if (row == board.length) { // 一行一行的做，如果一列一列的做那就得跟column的判断反过来
            return true;
        }
        if (column == board[0].length) { // 这一行做完了，所以列等于最大值，那就下一行了
            return backtrackMy1(board, row + 1, 0);
        }
        if (board[row][column] != '.') { // 已经有值了，那就下一个
            return backtrackMy1(board, row, column + 1);
        }
        for (char num = '1'; num <= '9'; num++) {
            if (!isValid(board, row, column, num)) {
                continue;
            }
            board[row][column] = num;
            if (backtrackMy1(board, row, column + 1)) {
                return true;
            }
            board[row][column] = '.';
        }
        return false;
    }

    private static boolean isValid(char[][] board, int row, int column, char num) {
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) { // 检查行有没有一样的值
                return false;
            }
            if (board[i][column] == num) { // 检查列有没有一样的值
                return false;
            }
            int subgridRow = (row / 3) * 3 + i / 3;
            int subgridColumn = (column / 3) * 3 + i % 3;
            if (board[subgridRow][subgridColumn] == num) { // 检查九宫格有没有一样的值
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][][] boardList = new char[][][]{
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                },
        };
        long startTime;
        long endTime;

        for (int i = 0; i < boardList.length; i++) {
            startTime = System.currentTimeMillis();
            solveSudokuMy1(boardList[i]);
            endTime = System.currentTimeMillis();
            System.out.print("solveSudoku My1 result" + i + " ");
            for (char[] list : boardList[i]) {
                for (char val : list) {
                    System.out.print(val + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
