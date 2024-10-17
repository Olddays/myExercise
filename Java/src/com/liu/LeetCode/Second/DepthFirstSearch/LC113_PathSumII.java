package com.liu.LeetCode.Second.DepthFirstSearch;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC113_PathSumII {
    private static List<List<Integer>> pathSumMy1(TreeNode root, int targetSum) {
        if (root == null) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        deepFirstPathSearch(root, targetSum, result, path, root.val);
        return result;
    }

    private static void deepFirstPathSearch(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> path, int sum) {
        if (root.left == null && root.right == null) {
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
            return;
        }

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
    }
}
