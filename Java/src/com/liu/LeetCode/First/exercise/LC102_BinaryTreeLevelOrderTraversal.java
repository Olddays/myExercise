package com.liu.LeetCode.First.exercise;

import com.liu.LeetCode.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC102_BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Map<Integer, List<Integer>> set = new HashMap<>();
        preOrderCheck(root, set, 0);
        for (Map.Entry<Integer, List<Integer>> entry : set.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    private static void preOrderCheck(TreeNode node, Map<Integer, List<Integer>> set, int depth) {
        if (null != node) {
            List<Integer> list;
            if (set.containsKey(depth)) {
                list = set.get(depth);
            } else {
                list = new ArrayList<>();
            }
            list.add(node.val);
            set.put(depth, list);
            preOrderCheck(node.left, set, depth + 1);
            preOrderCheck(node.right, set, depth + 1);
        }
    }
}
