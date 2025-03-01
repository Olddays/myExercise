package com.liu.LeetCode.Daily.Daily202502;

import com.liu.LeetCode.common.bean.TreeNode;
import com.liu.LeetCode.common.tools.Utils;

public class LC889_ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    // Beats 100.00%
    private static int preIndex = 0;
    private static int posIndex = 0;

    public static TreeNode constructFromPrePostAnswer1(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[posIndex]) {
            root.left = constructFromPrePostAnswer1(preorder, postorder);
        }
        if (root.val != postorder[posIndex]) {
            root.right = constructFromPrePostAnswer1(preorder, postorder);
        }
        posIndex++;
        return root;
    }

    public static void main(String[] args) {
        int[][] preorderList = new int[][]{
                {1, 2, 4, 5, 3, 6, 7},
                {1},
        };
        int[][] postorderList = new int[][]{
                {4, 5, 2, 6, 7, 3, 1},
                {1},
        };
        long startTime;
        TreeNode result;
        long endTime;

        for (int i = 0; i < preorderList.length; i++) {
            preIndex = 0;
            posIndex = 0;
            startTime = System.currentTimeMillis();
            result = constructFromPrePostAnswer1(preorderList[i], postorderList[i]);
            endTime = System.currentTimeMillis();
            System.out.println("constructFromPrePost Answer1 result" + i + " "
                    + Utils.getNodePrintableLog(Utils.NODE_TYPE.NODE_TYPE_LEVEL_ORDER_BINARY_TREE_ROOT, result)
                    + " during time " + (endTime - startTime));
        }
    }
}
