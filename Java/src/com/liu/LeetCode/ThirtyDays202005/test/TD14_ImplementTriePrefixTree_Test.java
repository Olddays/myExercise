package com.liu.LeetCode.ThirtyDays202005.test;


import com.liu.LeetCode.ThirtyDays202005.exercise.TD14_ImplementTriePrefixTree.Trie;

/**
 * Created by Liu on 2020/5/14.
 */
public class TD14_ImplementTriePrefixTree_Test {
    public static void main(String[] args) {
        Trie trie = new Trie();
        boolean result;

        trie.insert("apple");
        result = trie.search("apple");   // returns true
        System.out.println("trie.search: " + result);
        result = trie.search("app");     // returns false
        System.out.println("trie.search: " + result);
        result = trie.startsWith("app"); // returns true
        System.out.println("trie.search: " + result);
        trie.insert("app");
        result = trie.search("app");     // returns true
        System.out.println("trie.search: " + result);
    }
}
