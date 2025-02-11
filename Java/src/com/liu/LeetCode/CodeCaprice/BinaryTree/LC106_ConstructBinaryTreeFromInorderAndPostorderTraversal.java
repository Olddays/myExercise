package com.liu.LeetCode.CodeCaprice.BinaryTree;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.factory.NodeCreator;
import com.liu.LeetCode.common.tools.Utils;

public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // 中序左中右和后序左右中，通过后序来判断中间节点，通过中序进行切分
    // Beats 8.60% 因为Java的特性，不能简单的进行数组操作，耗费时间的主要是在新数组的创建与拷贝，如果改为index的方式，那么会节省很多时间
    private static TreeNode buildTreeMy1(int[] inorder, int[] postorder) {
        // 后序空则空节点，后序最后一个就是节点元素
        // 通过后序的节点寻中序进行切割左右
        // 切割中序，切割后序
        // 递归处理后续内容
        if (postorder.length == 0) {
            return null;
        }
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        if (postorder.length == 1) {
            return root;
        }
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        int[] inorderLeft = new int[index];
        int[] inorderRight = new int[inorder.length - index - 1];
        System.arraycopy(inorder, 0, inorderLeft, 0, inorderLeft.length);
        System.arraycopy(inorder, index + 1, inorderRight, 0, inorderRight.length); // 注意这里的index
        int[] postorderLeft = new int[index];
        int[] postorderRight = new int[postorder.length - index - 1];
        System.arraycopy(postorder, 0, postorderLeft, 0, postorderLeft.length);
        System.arraycopy(postorder, index, postorderRight, 0, postorderRight.length);
        root.left = buildTreeMy1(inorderLeft, postorderLeft);
        root.right = buildTreeMy1(inorderRight, postorderRight);
        return root;
    }

    // Beats 32.89%
    private static TreeNode buildTreeMy2(int[] inorder, int[] postorder) {
        return buildTreeMy2Helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode buildTreeMy2Helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                index = i;
                break;
            }
        }
        int leftSize = index - inStart;
        int rightSize = inEnd - index;
        root.left = buildTreeMy2Helper(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        root.right = buildTreeMy2Helper(inorder, index + 1, inEnd, postorder, postEnd - rightSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[][] inorderSet = new int[][]{
                {9, 3, 15, 20, 7},
                {-1},
        };
        int[][] postorderSet = new int[][]{
                {9, 15, 7, 20, 3},
                {-1},
        };
        TreeNode result;
        long startTime;
        long endTime;

        for (int i = 0; i < inorderSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = buildTreeMy1(inorderSet[i], postorderSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("buildTree My1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }

        for (int i = 0; i < inorderSet.length; i++) {
            startTime = System.currentTimeMillis();
            result = buildTreeMy2(inorderSet[i], postorderSet[i]);
            endTime = System.currentTimeMillis();
            System.out.println("buildTree My2 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
