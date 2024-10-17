package com.liu.LeetCode.ThirtyDays202006.exercise;

import com.liu.LeetCode.common.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/6/27.
 */
public class TD26_SumRootToLeafNumbers {

    public static int sumNumbers(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        depthFirstSearch(root, list, 0);
        int result = 0;
        for (int i : list) {
            result += i;
        }
        return result;
    }

    private static void depthFirstSearch(TreeNode root, List<Integer> list, int cache) {
        if (root != null) {
            cache = cache * 10 + root.val;
            if (root.left == null && root.right == null) {
                list.add(cache);
            }
            depthFirstSearch(root.left, list, cache);
            depthFirstSearch(root.right, list, cache);
        }
    }
}
