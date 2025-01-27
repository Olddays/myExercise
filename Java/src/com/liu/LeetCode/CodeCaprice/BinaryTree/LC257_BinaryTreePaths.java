package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.Node;
import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC257_BinaryTreePaths {

    // beats 40.41%
    private static List<String> binaryTreePathsMy1(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        depthFirstTraversalMy1(root, result, "");
        return result;
    }

    // 前序遍历
    private static void depthFirstTraversalMy1(TreeNode node, List<String> result, String path) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            result.add(path + node.val);
            return;
        }
        depthFirstTraversalMy1(node.left, result, path + node.val + "->");
        depthFirstTraversalMy1(node.right, result, path + node.val + "->");
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, 2, 3, Integer.MIN_VALUE, 5},
                {1},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = binaryTreePathsMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("binaryTreePaths My1 result" + i + " ");
            for (String val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
