package com.liu.LeetCode.First.exercise;


import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Liu on 2020/4/9.
 */
public class LC100_SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        ArrayList<Integer> pCache = new ArrayList<>();
        preOrderTraversal(p, pCache);
        ArrayList<Integer> qCache = new ArrayList<>();
        preOrderTraversal(q, qCache);
        if (pCache.size() != qCache.size()) {
            return false;
        }
        for (int i = 0; i < pCache.size(); i++) {
            if (!Objects.equals(pCache.get(i), qCache.get(i))) {
                System.out.println(pCache.get(i) + " " + qCache.get(i));
                return false;
            }
        }
        return true;
    }

    private static void preOrderTraversal(TreeNode node, ArrayList<Integer> cache) {
        if (node != null) {
            cache.add(node.val);
            if (node.left != null) {
                preOrderTraversal(node.left, cache);
            } else {
                cache.add(0);
            }
            if (node.right != null) {
                preOrderTraversal(node.right, cache);
            } else {
                cache.add(0);
            }
        }
    }
}
