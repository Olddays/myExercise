package com.liu.LeetCode.Second.BinaryTreeTraversal;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;

public class LC257_BinaryTreePaths {
    private static List<String> binaryTreePathsMy1(TreeNode root) { // accepted 性能一般
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        String path = "";
        depthFirstTraversal(root, result, path);
        return result;
    }

    private static void depthFirstTraversal(TreeNode root, List<String> result, String path) {
        if (root == null) {
            return;
        }
        path += root.val;
        if ((root.left != null || root.right != null)) {
            path += "->";
        } else {
            result.add(path);
            // 这里不需要将path设置成空字符串，因为在递归中会被重新赋值
        }
        depthFirstTraversal(root.left, result, path);
        depthFirstTraversal(root.right, result, path);
    }

    public static void main(String[] args) {
        int[][] rootNodeSet = new int[][]{
                {1, 2, 3, Integer.MIN_VALUE, 5},
                {1},
        };
        List<String> result;
        long startTime;
        long endTime;

        for (int i = 0; i < rootNodeSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = binaryTreePathsMy1((TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_PREORDER_BINARY_TREE_ROOT, rootNodeSet[i]));
            endTime = System.currentTimeMillis();
            System.out.print("binaryTreePaths My1 result" + i + " ");
            for (String s : result) {
                System.out.print(s + ";");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
