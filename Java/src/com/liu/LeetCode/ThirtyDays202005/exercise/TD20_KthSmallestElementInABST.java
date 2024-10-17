package com.liu.LeetCode.ThirtyDays202005.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/5/21.
 */
public class TD20_KthSmallestElementInABST {

    public static int kthSmallest(TreeNode root, int k) {
        List<Integer> cache = new ArrayList<>();
        preOrderCheck(root, cache);
        return cache.get(k - 1);
    }

    private static void preOrderCheck(TreeNode root, List<Integer> cache) {
        if (root != null) {
            preOrderCheck(root.left, cache);
            cache.add(root.val);
            preOrderCheck(root.right, cache);
        }
    }
}
