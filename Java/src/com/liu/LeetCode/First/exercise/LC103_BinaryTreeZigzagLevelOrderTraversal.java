package com.liu.LeetCode.First.exercise;

import java.util.*;

public class LC103_BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> zigzagLevelOrderMy1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Map<Integer, List<Integer>> set = new HashMap<>();
        preOrderCheck(root, set, 0);
        int depth = 0;
        for (Map.Entry<Integer, List<Integer>> entry : set.entrySet()) {
            if (depth % 2 == 0) {
                result.add(entry.getValue());
            } else {
                List<Integer> cache = new ArrayList<>();
                for (int i : entry.getValue()) {
                    cache.add(0, i);
                }
                result.add(cache);
            }
            depth++;
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

    public static List<List<Integer>> zigzagLevelOrderAnswer(TreeNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private static void travel(TreeNode curr, List<List<Integer>> sol, int level) {
        if (curr == null) return;

        if (sol.size() <= level) {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection = sol.get(level);
        if (level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }
}
