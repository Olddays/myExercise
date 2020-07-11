package com.liu.LeetCode.ThirtyDays202007.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liu on 2020/7/10.
 */
public class TD09_MaimumWidthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Time Limited
    public static int widthOfBinaryTreeMy1(TreeNode root) {
        int result = 0;
        if (root != null) {
            ArrayList<TreeNode> nodeList = new ArrayList<>();
            nodeList.add(root);
            result = 1;
            result = Math.max(result, widthFirstSearchByLayerMy1(nodeList));
        }
        return result;
    }


    private static int widthFirstSearchByLayerMy1(ArrayList<TreeNode> nodeList) {
        ArrayList<TreeNode> nextNodeList = new ArrayList<>();
        if (nodeList != null && nodeList.size() > 0) {
            for (TreeNode node : nodeList) {
                if (node == null) {
                    nextNodeList.add(null);
                    nextNodeList.add(null);
                } else {
                    nextNodeList.add(node.left);
                    nextNodeList.add(node.right);
                }
            }
        }
        int result = 0;
        if (nextNodeList.size() > 0) {
            boolean foundStart = false;
            int start = 0;
            boolean foundEnd = false;
            int end = nextNodeList.size() - 1;
            for (int i = 0; i < nextNodeList.size(); i++) {
                TreeNode node = nextNodeList.get(i);
                if (node == null) {
                    continue;
                }
                if (!foundStart) {
                    foundStart = true;
                    start = i;
                } else {
                    foundEnd = true;
                    end = i;
                }
            }
            if (foundStart) {
                result = 1;
                if (foundEnd) {
                    result = end + 1 - start;
                }
                result = Math.max(result, widthFirstSearchByLayerMy1(nextNodeList));
            }
        }
        return result;
    }

    public static int widthOfBinaryTreeAnswer1(TreeNode root) {
        return depthFirstSearch(root, 0, 1, new ArrayList<>(), new ArrayList<>());
    }

    public static int depthFirstSearch(TreeNode root, int level, int order, List<Integer> start, List<Integer> end) {
        if (root == null) {
            return 0;
        }
        if (start.size() == level) {
            start.add(order);
            end.add(order);
        } else {
            end.set(level, order);
        }
        int current = end.get(level) - start.get(level) + 1;
        int left = depthFirstSearch(root.left, level + 1, 2 * order, start, end);
        int right = depthFirstSearch(root.right, level + 1, 2 * order + 1, start, end);
        return Math.max(current, Math.max(left, right));

    }
}
