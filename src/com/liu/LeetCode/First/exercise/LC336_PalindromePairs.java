package com.liu.LeetCode.First.exercise;

import java.util.*;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC336_PalindromePairs {
    /**
     * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
     * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
     * <p>
     * Example 1:
     * Given words = ["bat", "tab", "cat"]
     * Return [[0, 1], [1, 0]]
     * The palindromes are ["battab", "tabbat"]
     * Example 2:
     * Given words = ["abcd", "dcba", "lls", "s", "sssll"]
     * Return [[0, 1], [1, 0], [3, 2], [2, 4]]
     * The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]
     * Credits:
     * Special thanks to @dietpepsi for adding this problem and creating all test cases.
     */

    // 无法处理""一类的空输入
    public static List<List<Integer>> getPalindromePairsMy1(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int length = words.length;
        if (length == 0) {
            return result;
        }
        // 首先两个字符串A B,A的开头与B的结尾一致时,可以考虑AB的组合来判断是否回文
        Map<Character, List<Integer>> headCharMap = new HashMap<>();
        Map<Character, List<Integer>> tailCharMap = new HashMap<>();
        for (int i = 0; i < length; i++) { // O(n) 这一步其实是在剪枝
            String word = words[i];
            if (word.length() == 0) {
                continue;
            }
            char head = word.charAt(0);
            char tail = word.charAt(word.length() - 1);

            List<Integer> list;
            if (headCharMap.containsKey(head)) {
                list = headCharMap.get(head);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            headCharMap.put(head, list);

            if (tailCharMap.containsKey(tail)) {
                list = tailCharMap.get(tail);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            tailCharMap.put(tail, list);
        }
        for (Map.Entry<Character, List<Integer>> entry : headCharMap.entrySet()) {
            char c = entry.getKey();
            List<Integer> tailList = tailCharMap.get(c);
            if (null != tailList) {
                List<Integer> headList = entry.getValue();
                for (int head : headList) {
                    for (int tail : tailList) {
                        if (head == tail) {
                            continue;
                        }
                        String checkString = words[head] + words[tail];
                        if (isPalindromeMy1(checkString)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(head);
                            list.add(tail);
                            result.add(list);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindromeMy1(String preCheckedString) {
        int length = preCheckedString.length();
        for (int i = 0; i < length / 2; i++) {
            if (preCheckedString.charAt(i) != preCheckedString.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // 好的 Time Limit Exceeded 时间复杂度过高= =
    public static List<List<Integer>> getPalindromePairsMy2(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int length = words.length;
        if (length == 0) {
            return result;
        }
        // 首先两个字符串A B,A的开头与B的结尾一致时,可以考虑AB的组合来判断是否回文
        Map<Character, List<Integer>> headCharMap = new HashMap<>();
        Map<Character, List<Integer>> tailCharMap = new HashMap<>();
        boolean needCheckSingle = false; // 用于标记是否存在""的输入
        int emptyId = -1; // 题意中说明每个String只能存在一次，所以只需要记录一个位置
        for (int i = 0; i < length; i++) { // O(n) 这一步其实是在剪枝
            String word = words[i];
            if (word.length() == 0) {
                needCheckSingle = true;
                emptyId = i;
                continue;
            }
            char head = word.charAt(0);
            char tail = word.charAt(word.length() - 1);

            List<Integer> list;
            if (headCharMap.containsKey(head)) {
                list = headCharMap.get(head);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            headCharMap.put(head, list);

            if (tailCharMap.containsKey(tail)) {
                list = tailCharMap.get(tail);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            tailCharMap.put(tail, list);
        }
        for (Map.Entry<Character, List<Integer>> entry : headCharMap.entrySet()) {
            char c = entry.getKey();
            List<Integer> tailList = tailCharMap.get(c);
            if (null != tailList) {
                List<Integer> headList = entry.getValue();
                for (int head : headList) {
                    for (int tail : tailList) {
                        if (head == tail) {
                            continue;
                        }
                        String checkString = words[head] + words[tail];
                        if (isPalindromeMy1(checkString)) {
                            List<Integer> list = new ArrayList<>();
                            list.add(head);
                            list.add(tail);
                            result.add(list);
                        }
                    }
                }
            }
        }
        if (needCheckSingle) { // 针对""的输入的处理
            for (int i = 0; i < length; i++) {
                String word = words[i];
                if (word.length() == 0) {
                    continue;
                }
                if (isPalindromeMy1(word)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(emptyId);
                    list.add(i);
                    result.add(list);
                    list = new ArrayList<>();
                    list.add(i);
                    list.add(emptyId);
                    result.add(list);
                }
            }
        }
        return result;
    }

    /**
     * The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the input.
     * Consider the test case of ["a", ""];
     * <p>
     * Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <.
     * There may be duplicates in the output (consider test case ["abcd", "dcba"]).
     * Therefore I put a str2.length()!=0 to avoid duplicates.
     * <p>
     * Another way to avoid duplicates is to use Set<List<Integer>> ret = new HashSet<>();
     * and return new ArrayList<>(ret);
     */
    public static List<List<Integer>> getPalindromePairsAnswer1(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        int length = words.length;
        if (length < 2) {
            return result;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        for (int i = 0; i < words.length; i++) {
            // System.out.println(words[i]);
            for (int j = 0; j <= words[i].length(); j++) { // notice it should be "j <= words[i].length()"
                String str1 = words[i].substring(0, j);
                String str2 = words[i].substring(j);
                if (isPalindromeAnswer1(str1)) {
                    String str2rvs = new StringBuilder(str2).reverse().toString();
                    if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(map.get(str2rvs));
                        list.add(i);
                        result.add(list);
                        // System.out.printf("isPal(str1): %s\n", list.toString());
                    }
                }
                if (isPalindromeAnswer1(str2)) {
                    String str1rvs = new StringBuilder(str1).reverse().toString();
                    // check "str.length() != 0" to avoid duplicates
                    if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length() != 0) {
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(i);
                        list.add(map.get(str1rvs));
                        result.add(list);
                        // System.out.printf("isPal(str2): %s\n", list.toString());
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindromeAnswer1(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left <= right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 使用Trie(单词查找树)
     * https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word
     */
    private static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    public static List<List<Integer>> getPalindromePairsAnswer2(String[] words) {
        List<List<Integer>> res = new ArrayList<>();

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            addWord(root, words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            search(words, i, root, res);
        }
        return res;
    }

    private static void addWord(TrieNode root, String word, int index) {
        for (int i = word.length() - 1; i >= 0; i--) {
            int j = word.charAt(i) - 'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }
            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }
            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private static void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
        for (int j = 0; j < words[i].length(); j++) {
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
                res.add(Arrays.asList(i, root.index));
            }

            root = root.next[words[i].charAt(j) - 'a'];
            if (root == null) {
                return;
            }
        }

        for (int j : root.list) {
            if (i == j) {
                continue;
            }
            res.add(Arrays.asList(i, j));
        }
    }

    private static boolean isPalindrome(String word, int i, int j) {
        while (i < j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
