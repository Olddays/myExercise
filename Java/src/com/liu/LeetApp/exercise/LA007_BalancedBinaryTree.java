package com.liu.LeetApp.exercise;

/**
 * Created by liu on 2016/12/5.
 */
public class LA007_BalancedBinaryTree {

    // Given a binary tree, determine if it is height-balanced.

    // For this problem, a height-balanced binary tree is defined as a binary tree in which
    // the depth of the two subtrees of every node never differ by more than 1.

    // Difficulty: Easy

    public static class Node {
        public Node leftChild;
        public Node rightChild;
    }

    public static boolean balancedBinaryTreeMy1(Node root) {
        boolean result = false;
        if (null == root) {
            return result;
        }
        int left = getDeepMy1(root.leftChild);
        int right = getDeepMy1(root.rightChild);
        result = Math.abs(left - right) <= 1 && left >= 0 && right >= 0;
        return result;
    }

    public static int getDeepMy1(Node root) {
        if (null == root) {
            return 0;
        }
        int left = getDeepMy1(root.leftChild);
        int right = getDeepMy1(root.rightChild);
        if (left >= 0 && right >= 0 && Math.abs(left - right) <= 1) {
            return left >= right ? (left + 1) : (right + 1);
        }
        return -1;
    }

    public static boolean balancedBinaryTreeAnswer(Node root) {
        return getDeepAnswer(root) != -1;
    }

    public static int getDeepAnswer(Node root) {
        if (null == root) {
            return 0;
        }
        int left = getDeepAnswer(root.leftChild);
        int right = getDeepAnswer(root.rightChild);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
