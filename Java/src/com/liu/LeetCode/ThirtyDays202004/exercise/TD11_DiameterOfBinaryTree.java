package com.liu.LeetCode.ThirtyDays202004.exercise;

import com.liu.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TD11_DiameterOfBinaryTree {

    // 思路没错，遍历多了一倍，导致时间复杂度加倍了，没必要
    public static int diameterOfBinaryTreeMy1(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<Integer> leftCache = new ArrayList<>();
        List<Integer> rightCache = new ArrayList<>();
        getAllNodeWithPreOrder(root, leftCache, rightCache);
        int max = 0;
        for (int i = 0; i < leftCache.size(); i++) {
            max = Math.max(leftCache.get(i) + rightCache.get(i), max);
        }
        return max;
    }

    // 此处使用的cache和Max遍历判断是可以通过一个全局变量来省略的，可以进一步降低时间和空间复杂度
    // 但是如果使用全局变量，在Java环境中的数据域就会变乱，也会破坏工具类的定义，故依旧选择增加一个临时空间和循环，而避免全局变量
    public static int diameterOfBinaryTreeMy2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        List<Integer> cache = new ArrayList<>();
        getDepthRootCount(root, cache);
        int max = 0;
        for (int i : cache) {
            max = Math.max(i, max);
        }
        return max;
    }

    private static void getAllNodeWithPreOrder(TreeNode node, List<Integer> leftCache, List<Integer> rightCache) {
        if (null != node) {
            if (null != node.left) {
                leftCache.add(depthTree(node.left));
            } else {
                leftCache.add(0);
            }
            if (null != node.right) {
                rightCache.add(depthTree(node.right));
            } else {
                rightCache.add(0);
            }
            getAllNodeWithPreOrder(node.left, leftCache, rightCache);
            getAllNodeWithPreOrder(node.right, leftCache, rightCache);
        }
    }

    private static int depthTree(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(depthTree(node.left), depthTree(node.right)) + 1;
    }

    private static int getDepthRootCount(TreeNode node, List<Integer> cache) {
        if (null == node) {
            return 0;
        }
        int leftDepth = getDepthRootCount(node.left, cache);
        int rightDepth = getDepthRootCount(node.right, cache);
        cache.add(leftDepth + rightDepth);
        return Math.max(rightDepth, leftDepth) + 1;
    }

}
