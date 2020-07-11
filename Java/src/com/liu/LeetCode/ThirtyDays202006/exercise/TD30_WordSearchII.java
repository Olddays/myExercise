package com.liu.LeetCode.ThirtyDays202006.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/30.
 */
public class TD30_WordSearchII {
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                depthFirstSearch(board, i, j, root, res);
            }
        }
        return res;
    }

    public static void depthFirstSearch(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }

        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';

        if (i > 0) {
            depthFirstSearch(board, i - 1, j, p, res);
        }
        if (j > 0) {
            depthFirstSearch(board, i, j - 1, p, res);
        }
        if (i < board.length - 1) {
            depthFirstSearch(board, i + 1, j, p, res);
        }
        if (j < board[0].length - 1) {
            depthFirstSearch(board, i, j + 1, p, res);
        }
        board[i][j] = c;
    }

    public static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (node.next[i] == null) {
                    node.next[i] = new TrieNode();
                }
                node = node.next[i];
            }
            node.word = word;
        }
        return root;
    }

    public static class TrieNode {
        TrieNode[] next;
        String word;

        public TrieNode() {
            next = new TrieNode[26];
        }
    }
}
