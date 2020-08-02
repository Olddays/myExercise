package com.liu.LeetCode.ThirtyDays202007.exercise;

import com.liu.LeetCode.common.TreeNode;

import java.util.HashMap;

/**
 * Created by Liu on 2020/7/27.
 */
public class TD27_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            hm.put(inorder[i], i);
        }
        return buildTreePostIn(0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    private static TreeNode buildTreePostIn(int is, int ie, int[] postorder, int ps, int pe,
                                            HashMap<Integer, Integer> hm) {
        if (ps > pe || is > ie) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pe]);
        int ri = hm.get(postorder[pe]);
        TreeNode leftChild = buildTreePostIn(is, ri - 1, postorder, ps, ps + ri - is - 1, hm);
        TreeNode rightChild = buildTreePostIn(ri + 1, ie, postorder, ps + ri - is, pe - 1, hm);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }
}
