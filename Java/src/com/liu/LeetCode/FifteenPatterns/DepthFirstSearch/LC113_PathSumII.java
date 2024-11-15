package com.liu.LeetCode.FifteenPatterns.DepthFirstSearch;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Depth-First Search (DFS) is a traversal technique that explores as far down a branch as possible before backtracking.
 * Use this pattern for exploring all paths or branches in graphs or trees.
 * Sample Problem:
 * Find all paths from the root to leaves in a binary tree.
 * Example:
 * Input: root = [1, 2, 3, null, 5]
 * Output: ["1->2->5", "1->3"]
 * Explanation:
 * Use recursion or a stack to traverse each path from the root to the leaves.
 * Record each path as you traverse.
 */
public class LC113_PathSumII {
    private static List<List<Integer>> pathSumMy1(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        deepFirstPathSearchMy1(root, targetSum, result, path, 0);
        return result;
    }

    private static void deepFirstPathSearchMy1(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int newSum = sum + root.val;
        if (root.left == null && root.right == null && newSum == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            deepFirstPathSearchMy1(root.left, targetSum, result, path, newSum);
            deepFirstPathSearchMy1(root.right, targetSum, result, path, newSum);
        }
        path.remove(Integer.valueOf(root.val)); // 错误，应该去掉最后一个，如果树里面有一样的数字会导致删除出错
    }

    private static List<List<Integer>> pathSumMy2(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        deepFirstPathSearchMy2(root, targetSum, result, path, 0);
        return result;
    }

    private static void deepFirstPathSearchMy2(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        int newSum = sum + root.val;
        if (root.left == null && root.right == null && newSum == targetSum) {
            result.add(new ArrayList<>(path));
        } else {
            deepFirstPathSearchMy2(root.left, targetSum, result, path, newSum);
            deepFirstPathSearchMy2(root.right, targetSum, result, path, newSum);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[][] treeNodeSet = new int[][]{
                {5, 4, 8, 11, Integer.MIN_VALUE, 13, 4, 7, 2, Integer.MIN_VALUE, Integer.MIN_VALUE, 5, 1},
                {1, 2, 3},
                {1, 2},
        };
        int[] targetSumSet = new int[]{
                22,
                5,
                0,
        };
        List<List<Integer>> result;
        long startTime;
        long endTime;

        for (int i = 0; i < treeNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = pathSumMy1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, treeNodeSet[i]), targetSumSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("pathSum My1 result" + i + " ");
            for (List<Integer> list : result) {
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < treeNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = pathSumMy2((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, treeNodeSet[i]), targetSumSet[i]);
            endTime = System.currentTimeMillis();
            System.out.print("pathSum My2 result" + i + " ");
            for (List<Integer> list : result) {
                for (int num : list) {
                    System.out.print(num + ",");
                }
                System.out.print(";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
