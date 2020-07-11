package com.liu.LeetCode.ThirtyDays202006.exercise;

/**
 * Created by Liu on 2020/6/19.
 */
public class TD19_LongestDuplicateSubstring {
    // Time Limited
    public static String longestDupSubstringMy1(String S) {
        int length = S.length();
        if (length <= 1) {
            return "";
        }
        int substringLength = length - 1;
        while (substringLength > 0) {
            for (int i = 0; i < length - substringLength; i++) {
                String substring = S.substring(i, substringLength + i);
                int count = 0;
                for (int j = i; j < length - substringLength; j++) {
                    int has = S.indexOf(substring, j);
                    if (has >= 0) {
                        count++;
                    }
                }
                if (count > 1) {
                    return substring;
                }
            }
            substringLength--;
        }
        return "";
    }

    public static String longestDupSubstringAnswer1(String S) {
        int maxLo = 0, maxLength = 0;
        TrieNode root = new TrieNode(0, 0);
        for (int i = 1; i + maxLength < S.length(); i++) {
            int len = addNew(S, root, i);
            if (len > maxLength) {
                maxLength = len;
                maxLo = i;
            }
        }
        return S.substring(maxLo, maxLo + maxLength);
    }

    private static boolean isLeaf(TrieNode node) {
        return node.next == null;
    }

    private static int getIndex(String S, int i, int depth) {
        return S.charAt(i + depth) - 'a';
    }

    private static int addNew(String S, TrieNode node, int i) {
        int depth = node.depth;
        if (i + depth == S.length()) return depth;
        if (isLeaf(node)) {
            node.next = new TrieNode[26];
            node.next[getIndex(S, node.i, node.depth)] = new TrieNode(node.i, depth + 1);
        }
        int c = getIndex(S, i, node.depth);
        TrieNode x = node.next[c];
        if (x == null) {
            node.next[c] = new TrieNode(i, depth + 1);
            return depth;
        }
        return addNew(S, x, i);
    }

    private static class TrieNode {
        private TrieNode[] next;
        private int i;
        private int depth;

        public TrieNode(int i, int depth) {
            this.i = i;
            this.depth = depth;
        }
    }
}
