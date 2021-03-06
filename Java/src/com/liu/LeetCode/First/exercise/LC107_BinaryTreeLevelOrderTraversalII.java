package com.liu.LeetCode.First.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC107_BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static  List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Map<Integer, List<Integer>> set = new HashMap<>();
        preOrderCheck(root, set, 0);
        for (Map.Entry<Integer, List<Integer>> entry : set.entrySet()) {
            result.add(0, entry.getValue());
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
