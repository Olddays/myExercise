package com.liu.LeetCode.Daily.Daily202504;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.*;

public class LC1123_LowestCommonAncestorOfDeepestLeaves {

    // 首先要的是，让深度为MaxDepth的所有子节点，都被这个节点所持有，那么就需要找到所有的深度为MaxDepth的节点
    // 然后从这些节点中回溯，找到最小的共同的父节点，也就是第一个共同父节点
    // 用的逐层遍历，存了很多变量，还用了很多封装类，性能应该比较差，但理论上输出肯定是对的，好处是数据不会外溢到方法外，不会有全局变量
    // Beats 8.52%
    private static TreeNode lcaDeepestLeavesMy1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> map = new HashMap<>();
        List<TreeNode> depthList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                depthList.add(node);
                if (node.left != null) {
                    map.put(node.left, node);
                    queue.add(node.left);
                    depthList.add(node.left);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queue.add(node.right);
                    depthList.add(node.right);
                }
            }
            if (!queue.isEmpty()) {
                depthList.clear();
            }
        }
        while (depthList.size() > 1) {
            TreeNode node = depthList.get(0);
            depthList.remove(0);
            TreeNode parent = map.get(node);
            if (!depthList.contains(parent)) {
                depthList.add(parent);
            }
        }
        if (depthList.size() == 1) {
            return depthList.get(0);
        }
        return null;
    }

    static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // 求深度，那就得用后序，左右中
    // Beats 100.00%
    public static TreeNode lcaDeepestLeavesAnswer1(TreeNode root) {
        Pair pair = getLca(root, 0);
        return pair.node;
    }

    private static Pair getLca(TreeNode root, int depth) {
        if (root == null) {
            return new Pair(null, depth);
        }
        Pair l = getLca(root.left, depth + 1);
        Pair r = getLca(root.right, depth + 1);
        if (l.depth == r.depth) {
            return new Pair(root, l.depth); // 左右如果深度一样，那就是用自己
        } else {
            return l.depth > r.depth ? l : r; // 左右如果不一样，那就谁大用谁
        }
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4, 2, 3},
                {0, 1, 3, Integer.MIN_VALUE, 2},
                {1},
                {3, 5, 1, 6, 2, 0, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 7, 4},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = lcaDeepestLeavesMy1(node);
            endTime = System.currentTimeMillis();
            System.out.println("lcaDeepestLeaves My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = lcaDeepestLeavesAnswer1(node);
            endTime = System.currentTimeMillis();
            System.out.println("lcaDeepestLeaves Answer1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
