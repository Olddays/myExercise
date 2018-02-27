package com.liu.LeetCode.First.exercise;

/**
 * Created by baidu on 2017/9/30.
 */
public class LC106_ConstructBinaryTreeFromInorderAndPostorderTraversal {
    /**
     * Given inorder and postorder traversal of a tree, construct the binary tree.
     * <p>
     * Note:
     * You may assume that duplicates do not exist in the tree.
     * <p>
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // The basic idea is here:
    // Say we have 2 arrays, IN and POST.
    // Postorder traversing implies that POST[Length-1] is the root node.
    // Then we can find this POST[Length-1] in IN, say it's IN[5].
    // Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the right side, IN[6] to the end is on the left side.
    // Recursively doing this on subarrays, we can build a tree out of it.
    public static TreeNode getConstructBinaryTreeFromInorderAndPostorderTraversalMy1(int[] inorder, int[] postorder) {
        return checkTreePathMy1(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    // 当中序后序值一致时,说明只有左枝,此时postEnd-inIndex+inStart-1=-1,会导致直接返回null
    public static TreeNode checkTreePathMy1(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = checkTreePathMy1(postEnd - inIndex + inStart - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = checkTreePathMy1(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }

    public static TreeNode getConstructBinaryTreeFromInorderAndPostorderTraversalMy2(int[] inorder, int[] postorder) {
        return checkTreePathMy2(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    // 在循环过程中由于没有按照两侧进行区分导致在输入[1,2,3,4][1,4,3,2]的时候会出现问题
    public static TreeNode checkTreePathMy2(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        if (inIndex - inEnd == 0) {
            root.left = checkTreePathMy2(postEnd - 1, inStart, inIndex - 1, inorder, postorder);
        } else {
            root.left = checkTreePathMy2(postEnd - inIndex + inStart - 1, inStart, inIndex - 1, inorder, postorder);
            root.right = checkTreePathMy2(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        }
        return root;
    }

    public static TreeNode getConstructBinaryTreeFromInorderAndPostorderTraversalMy3(int[] inorder, int[] postorder) {
        return checkTreePathMy3(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }

    public static TreeNode checkTreePathMy3(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        if (postEnd < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        // postEnd - inEnd + inIndex - 1 这部分最重要,即对于左枝,要移动inEnd-inIndex的距离
        root.left = checkTreePathMy3(postEnd - inEnd + inIndex - 1, inStart, inIndex - 1, inorder, postorder);
        root.right = checkTreePathMy3(postEnd - 1, inIndex + 1, inEnd, inorder, postorder);
        return root;
    }
}
