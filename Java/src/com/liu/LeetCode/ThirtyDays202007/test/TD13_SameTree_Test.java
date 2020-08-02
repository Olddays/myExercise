package com.liu.LeetCode.ThirtyDays202007.test;


import com.liu.LeetCode.common.TreeNode;

import static com.liu.LeetCode.ThirtyDays202007.exercise.TD13_SameTree.isSameTree;

/**
 * Created by Liu on 2020/7/13.
 */
public class TD13_SameTree_Test {

    public static void main(String[] args) {
        TreeNode p;
        TreeNode q;
        boolean result;
        long startTime;
        long endTime;

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);
        startTime = System.currentTimeMillis();
        result = testMy1(p, q);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_SameTree My 1 result " + result + " during time " + (endTime - startTime));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        q = new TreeNode(1);
        q.right = new TreeNode(2);
        startTime = System.currentTimeMillis();
        result = testMy1(p, q);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_SameTree My 1 result " + result + " during time " + (endTime - startTime));

        p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);
        q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);
        startTime = System.currentTimeMillis();
        result = testMy1(p, q);
        endTime = System.currentTimeMillis();
        System.out.println("TD13_SameTree My 1 result " + result + " during time " + (endTime - startTime));

    }

    private static boolean testMy1(TreeNode p, TreeNode q) {
        return isSameTree(p, q);
    }
}
