package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_BinaryTreePostorderTraversal {

    private static List<Integer> postorderTraversalMy1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }

    private static void postorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, result);
        postorderTraversalHelper(root.right, result);
        result.add(root.val);
    }

    private static List<Integer> postorderTraversalMy2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            result.add(node.val); // 中
            if (node.left != null) { // 左
                nodeStack.push(node.left);
            }
            if (node.right != null) { // 右
                nodeStack.push(node.right);
            }
        }
        // 现在是中左右，进行反转成右左中
        int left = 0;
        int right = result.size() - 1;
        while (left < right) {
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            left++;
            right--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] valuesSet = new int[][]{
                {1, Integer.MIN_VALUE, 2, 3},
                {1, 2, 3, 4, 5, Integer.MIN_VALUE, 8, Integer.MIN_VALUE, Integer.MIN_VALUE, 6, 7, 9},
                {1},
        };
        List<Integer> result;
        long startTime;
        long endTime;

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = postorderTraversalMy1(node);
            endTime = System.currentTimeMillis();
            System.out.print("postorderTraversal My1 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }

        for (int i = 0; i < valuesSet.length; i++) {
            TreeNode node = (TreeNode) NodeCreator.createNode(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, valuesSet[i]);
            startTime = System.currentTimeMillis();
            result = postorderTraversalMy2(node);
            endTime = System.currentTimeMillis();
            System.out.print("postorderTraversal My2 result" + i + " ");
            for (int val : result) {
                System.out.print(val + ",");
            }
            System.out.println(" during time " + (endTime - startTime));
        }
    }
}
