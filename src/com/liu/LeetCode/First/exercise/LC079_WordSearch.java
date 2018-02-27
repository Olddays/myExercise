package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC079_WordSearch {
    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     * <p>
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
     * <p>
     * For example,
     * Given board =
     * <p>
     * [
     * ['A','B','C','E'],
     * ['S','F','C','S'],
     * ['A','D','E','E']
     * ]
     * <p>
     * word = "ABCCED", -> returns true,
     * word = "SEE", -> returns true,
     * word = "ABCB", -> returns false.
     */

    // 在重组char的时候写错了,i * row + j应该改为i * list + j
    public static boolean getWordSearchMy1(char[][] board, String word) {
        int row = board.length;
        if (null == word || word.length() == 0 || row == 0) {
            return false;
        }
        int list = board[0].length;
        char[] boardChars = new char[row * list];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                boardChars[i * row + j] = board[i][j];
            }
        }
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        Arrays.sort(boardChars);
        int left = 0;
        int right = boardChars.length - 1;
        while (left < right) {
            if (boardChars[left] < wordChars[0]) {
                left++;
            } else if (boardChars[right] > wordChars[wordChars.length - 1]) {
                right--;
            } else if (boardChars[left] >= wordChars[0]
                    && boardChars[right] <= wordChars[wordChars.length - 1]) {
                break;
            }
        }
        int matchCount = 0;
        for (char c : wordChars) {
            for (int i = left; i <= right; i++) {
                if (c == boardChars[i]) {
                    matchCount++;
                    boardChars[i] = ' ';
                    break;
                }
            }
        }
        return matchCount == word.length();
    }

    // 题目理解错了,此方案只能处理判断board中的字符是否能够无放回的组成word
    public static boolean getWordSearchMy2(char[][] board, String word) {
        int row = board.length;
        if (null == word || word.length() == 0 || row == 0) {
            return false;
        }
        int list = board[0].length;
        char[] boardChars = new char[row * list];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                // 此处的i标示遍历过了多少行,而每一行有list个列
                boardChars[i * list + j] = board[i][j];
            }
        }
        char[] wordChars = word.toCharArray();
        Arrays.sort(wordChars);
        Arrays.sort(boardChars);
        int left = 0;
        int right = boardChars.length - 1;
        while (left < right) {
            if (boardChars[left] < wordChars[0]) {
                left++;
            } else if (boardChars[right] > wordChars[wordChars.length - 1]) {
                right--;
            } else if (boardChars[left] >= wordChars[0]
                    && boardChars[right] <= wordChars[wordChars.length - 1]) {
                break;
            }
        }
        int matchCount = 0;
        for (char c : wordChars) {
            for (int i = left; i <= right; i++) {
                if (c == boardChars[i]) {
                    matchCount++;
                    boardChars[i] = ' ';
                    break;
                }
            }
        }
        return matchCount == word.length();
    }

    // 遍历难度相对高,这个首先要找到word的开头然后以此点开始在周围寻找,显然又是一个深度搜索问题
    public static boolean getWordSearchMy3(char[][] board, String word) {
        int row = board.length;
        if (null == word || word.length() == 0 || row == 0) {
            return false;
        }
        int list = board[0].length;
        return backtrackAroundMy3(board, word, row, list, 0, row - 1, 0, list - 1, 0, true);
    }

    // 这段逻辑可以遍历某点周围一圈的数据,本题目应该只关注上下左右
    // 还有一个问题:当一个点周围有多个可选点时,无法继续回归
    private static boolean backtrackAroundMy3(char[][] board, String word, int row, int list,
                                              int rowStart, int rowEnd, int listStart, int listEnd,
                                              int charId, boolean isFirst) {
        if (charId >= word.length()) {
            return true;
        }
        char c = word.charAt(charId);
        int midRow = (rowEnd + rowStart) / 2;
        int midList = (listEnd + listStart) / 2;
        for (int i = rowStart; i <= rowEnd; i++) {
            for (int j = listStart; j <= listEnd; j++) {
                if (i == midRow && j == midList && !isFirst) {
                    continue; // 规避自己 要考虑第一次进入且第一个match为[0,0]的时候怎么处理
                }
                if (board[i][j] == c) {
                    int newRowStart = Math.max(0, i - 1);
                    int newRowEnd = Math.min(row - 1, i + 1);
                    int newListStart = Math.max(0, j - 1);
                    int newListEnd = Math.min(list - 1, j + 1);
                    return backtrackAroundMy3(board, word, row, list, newRowStart, newRowEnd, newListStart, newListEnd, ++charId, false);
                }
            }
        }
        return false;
    }

    // 没有考虑到每个值只能用一次,所以在类似[[a],[a]] 'aaa'的输入时会判断错误
    public static boolean getWordSearchMy4(char[][] board, String word) {
        int row = board.length;
        if (null == word || word.length() == 0 || row == 0) {
            return false;
        }
        int list = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean result = backtrackMy4(board, word, row, list, i, j, 1);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 只关注上下左右
    private static boolean backtrackMy4(char[][] board, String word, int row, int list,
                                        int matchRow, int matchList, int charId) {
        if (charId >= word.length()) {
            return true;
        }
        int up = Math.max(0, matchRow - 1);
        int down = Math.min(matchRow + 1, row - 1);
        int left = Math.max(0, matchList - 1);
        int right = Math.min(matchList + 1, list - 1);
        char c = word.charAt(charId);
        if (board[up][matchList] == c && up != matchRow) {
            // 上
            boolean check = backtrackMy4(board, word, row, list, up, matchList, ++charId);
            if (!check) {
                --charId;
            } else {
                return true;
            }
        }
        if (board[down][matchList] == c && down != matchRow) {
            // 下
            boolean check = backtrackMy4(board, word, row, list, down, matchList, ++charId);
            if (!check) {
                --charId;
            } else {
                return true;
            }
        }
        if (board[matchRow][left] == c && left != matchList) {
            //左
            boolean check = backtrackMy4(board, word, row, list, matchRow, left, ++charId);
            if (!check) {
                --charId;
            } else {
                return true;
            }
        }
        if (board[matchRow][right] == c && right != matchList) {
            // 右
            boolean check = backtrackMy4(board, word, row, list, matchRow, right, ++charId);
            if (!check) {
                --charId;
            } else {
                return true;
            }
        }
        return false;
    }

    // 还是有问题,...蛋疼
    public static boolean getWordSearchMy5(char[][] board, String word) {
        int row = board.length;
        if (null == word || word.length() == 0 || row == 0) {
            return false;
        }
        int list = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < list; j++) {
                if (board[i][j] == word.charAt(0)) {
                    List<String> pathCache = new ArrayList<>();
                    pathCache.add(i + "" + j);
                    boolean result = backtrackMy5(board, word, pathCache, row, list, i, j, 1, true);
                    if (result) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // 只关注上下左右
    private static boolean backtrackMy5(char[][] board, String word, List<String> pathCache, int row, int list,
                                        int matchRow, int matchList, int charId, boolean isFirst) {
        if (charId >= word.length()) {
            return true;
        }
        if (!isFirst) {
            String point = matchRow + "" + matchList;
            if (pathCache.contains(point)) {
                return false;
            }
            pathCache.add(point);
        }
        int up = Math.max(0, matchRow - 1);
        int down = Math.min(matchRow + 1, row - 1);
        int left = Math.max(0, matchList - 1);
        int right = Math.min(matchList + 1, list - 1);
        char c = word.charAt(charId);
        if (board[up][matchList] == c && up != matchRow) {
            // 上
            boolean check = backtrackMy5(board, word, pathCache, row, list, up, matchList, ++charId, false);
            if (!check) {
                int pathSize = pathCache.size() - 1;
                if (charId == pathSize) {
                    // 为了遍历其他可能路径,要记得把保存的位置cache给remove掉
                    // 当charId和pathSize一致的时候证明我们在上一次递归中加入了pathCache,此时才应该进行remove
                    pathCache.remove(pathSize);
                }
                --charId;
            } else {
                return true;
            }
        }
        if (board[down][matchList] == c && down != matchRow) {
            // 下
            boolean check = backtrackMy5(board, word, pathCache, row, list, down, matchList, ++charId, false);
            if (!check) {
                int pathSize = pathCache.size() - 1;
                if (charId == pathSize) {
                    // 为了遍历其他可能路径,要记得把保存的位置cache给remove掉
                    // 当charId和pathSize一致的时候证明我们在上一次递归中加入了pathCache,此时才应该进行remove
                    pathCache.remove(pathSize);
                }
                --charId;
            } else {
                return true;
            }
        }
        if (board[matchRow][left] == c && left != matchList) {
            //左
            boolean check = backtrackMy5(board, word, pathCache, row, list, matchRow, left, ++charId, false);
            if (!check) {
                int pathSize = pathCache.size() - 1;
                if (charId == pathSize) {
                    // 为了遍历其他可能路径,要记得把保存的位置cache给remove掉
                    // 当charId和pathSize一致的时候证明我们在上一次递归中加入了pathCache,此时才应该进行remove
                    pathCache.remove(pathSize);
                }
                --charId;
            } else {
                return true;
            }
        }
        if (board[matchRow][right] == c && right != matchList) {
            // 右
            boolean check = backtrackMy5(board, word, pathCache, row, list, matchRow, right, ++charId, false);
            if (!check) {
                int pathSize = pathCache.size() - 1;
                if (charId == pathSize) {
                    // 为了遍历其他可能路径,要记得把保存的位置cache给remove掉
                    // 当charId和pathSize一致的时候证明我们在上一次递归中加入了pathCache,此时才应该进行remove
                    pathCache.remove(pathSize);
                }
                --charId;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean getWordSearchAnswer1(char[][] board, String word) {
        char[] w = word.toCharArray();
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (exist(board, y, x, w, 0)) return true;
            }
        }
        return false;
    }

    // board[y][x] ^= 256 it's a marker that the letter at position x,y is a part of word we search.
    // After board[y][x] ^= 256 the char became not a valid letter. After second board[y][x] ^= 256
    // it became a valid letter again.
    private static boolean exist(char[][] board, int y, int x, char[] word, int i) {
        if (i == word.length) return true;
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) return false;
        if (board[y][x] != word[i]) return false;
        board[y][x] ^= 256;
        boolean exist = exist(board, y, x + 1, word, i + 1)
                || exist(board, y, x - 1, word, i + 1)
                || exist(board, y + 1, x, word, i + 1)
                || exist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}
